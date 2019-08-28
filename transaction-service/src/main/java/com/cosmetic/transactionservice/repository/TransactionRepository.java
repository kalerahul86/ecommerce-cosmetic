package com.cosmetic.transactionservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cosmetic.cosmetic_common.entity.Transaction;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, String>{

}
