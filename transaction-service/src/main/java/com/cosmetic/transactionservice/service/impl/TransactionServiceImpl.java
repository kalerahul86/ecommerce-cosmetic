package com.cosmetic.transactionservice.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cosmetic.cosmetic_common.dto.TransactionDto;
import com.cosmetic.cosmetic_common.entity.Transaction;
import com.cosmetic.cosmetic_common.exception.CosmeticException;
import com.cosmetic.transactionservice.repository.TransactionRepository;
import com.cosmetic.transactionservice.service.TransactionService;

@Service
@Transactional(rollbackOn = Exception.class)
public class TransactionServiceImpl implements TransactionService {

    private static final Logger logger = LoggerFactory.getLogger(TransactionServiceImpl.class);
    
    @Autowired
    private TransactionRepository transactionRepository;
    
    @Autowired
    private ModelMapper modelMapper;
    
    @Override
    public TransactionDto get(String id) throws CosmeticException {
        
        logger.info("Getting transaction..");
        Transaction transaction = transactionRepository.findById(id).orElse(null);
        return modelMapper.map(transaction, TransactionDto.class);
    }

    @Override
    public TransactionDto add(TransactionDto transactionDto) throws CosmeticException {
        
        logger.info("Inserting all transaction..");
        Transaction transaction = transactionRepository.save(modelMapper.map(transactionDto, Transaction.class));
        return modelMapper.map(transaction, TransactionDto.class);
    }

    @Override
    public TransactionDto update(TransactionDto transactionDto) throws CosmeticException {
        
        logger.info("Updating all transaction..");
        Transaction transaction = transactionRepository.save(modelMapper.map(transactionDto, Transaction.class));
        return modelMapper.map(transaction, TransactionDto.class);
    }

    @Override
    public List<TransactionDto> getAllTransactions() throws CosmeticException {
        
        logger.info("Getting all transaction..");
        List<Transaction> allTransactions = transactionRepository.findAll();        
        return modelMapper.map(allTransactions, new TypeToken<List<TransactionDto>>() {}.getType());
    }

}
