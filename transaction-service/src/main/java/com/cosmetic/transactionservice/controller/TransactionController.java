package com.cosmetic.transactionservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cosmetic.cosmetic_common.dto.TransactionDto;
import com.cosmetic.cosmetic_common.exception.CosmeticException;
import com.cosmetic.transactionservice.service.TransactionService;

@CrossOrigin
@RestController
@RequestMapping(path = "/transaction/", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @RequestMapping(method = RequestMethod.POST)
    public void add(@RequestBody TransactionDto transaction) throws CosmeticException {
        transactionService.add(transaction);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public void update(@RequestBody TransactionDto transaction) throws CosmeticException {
        transactionService.update(transaction);
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public TransactionDto get(@PathVariable("id") String id) throws CosmeticException {
        return transactionService.get(id);
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<TransactionDto> get() throws CosmeticException {
        return transactionService.getAllTransactions();
    }
}
