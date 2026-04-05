package com.finsentinel.service;

import com.finsentinel.dto.TransactionRequestDTO;
import com.finsentinel.dto.TransactionResponseDTO;

public interface TransactionService {
    TransactionResponseDTO processTransaction(TransactionRequestDTO request);
}
