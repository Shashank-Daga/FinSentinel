package com.finsentinel.controller;

import com.finsentinel.dto.TransactionResponseDTO;
import com.finsentinel.dto.TransactionRequestDTO;
import com.finsentinel.service.TransactionService;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/transactions")
@RequiredArgsConstructor
public class TransactionController {
    private final TransactionService transactionService;

    @PostMapping
    public TransactionResponseDTO createTransaction(@RequestBody TransactionRequestDTO request){
        return transactionService.processTransaction(request);
    }
}
