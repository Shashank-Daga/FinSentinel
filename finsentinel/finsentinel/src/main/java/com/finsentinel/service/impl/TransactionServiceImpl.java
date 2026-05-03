package com.finsentinel.service.impl;

import com.finsentinel.dto.TransactionRequestDTO;
import com.finsentinel.dto.TransactionResponseDTO;
import com.finsentinel.fraud.FraudDetectionService;
import com.finsentinel.model.Transaction;
import com.finsentinel.model.User;
import com.finsentinel.repository.TransactionRepository;
import com.finsentinel.repository.UserRepository;
import com.finsentinel.service.TransactionService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class TransactionServiceImpl implements TransactionService{
    private final UserRepository userRepository;
    private final FraudDetectionService fraudDetectionService;

    @Override
    public TransactionResponseDTO processTransaction(TransactionRequestDTO request){
        User user = userRepository.findByAccountNumber(request.getAccountNumber())
                .orElseThrow(() -> new RuntimeException("User not found"));

        Transaction transaction = Transaction.builder()
                .user(user)
                .amount(request.getAmount())
                .location(request.getLocation())
                .deviceId(request.getDeviceId())
                .merchantCategory(request.getMerchantCategory())
                .transactionType(request.getTransactionType())
                .ipAddress(request.getIpAddress())
                .deviceType(request.getDeviceType())
                .status("PENDING")
                .riskScore(0.0)
                .build();

        Transaction analyzed = fraudDetectionService.analyzeTransaction(transaction);

        return TransactionResponseDTO.builder()
                .transactionId(analyzed.getId())
                .status(analyzed.getStatus())
                .riskScore(analyzed.getRiskScore())
                .build();
    }
}
