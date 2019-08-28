package com.cosmetic.transactionservice.service;

import java.util.List;

import com.cosmetic.cosmetic_common.dto.TransactionDto;
import com.cosmetic.cosmetic_common.exception.CosmeticException;

public interface TransactionService {

    /**
     * Get Transaction by Id
     * 
     * @param id
     * @return
     */
    TransactionDto get(String id) throws CosmeticException;
    
    /**
     * Save Transaction
     * 
     * @param transactionDto
     * @return
     * @throws CosmeticException
     */
    TransactionDto add(TransactionDto transactionDto) throws CosmeticException;
    
    /**
     * Update transaction
     * 
     * @param transactionDto
     * @return
     * @throws CosmeticException
     */
    TransactionDto update(TransactionDto transactionDto) throws CosmeticException;
    
    /**
     * Get all transactions
     * 
     * @return
     * @throws CosmeticException
     */
    List<TransactionDto> getAllTransactions() throws CosmeticException; 
}
