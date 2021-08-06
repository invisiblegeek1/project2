package com.example.TransactionServer.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.TransactionServer.Entity.Transaction;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction,Integer>{

}
