package com.example.TransactionServer.Service;

import com.example.TransactionServer.Entity.Transaction;
import com.example.TransactionServer.Repository.TransactionRepository;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;




@NoArgsConstructor
@AllArgsConstructor
@Data
public class TransactionResponse {
	private ResponseStatus status;
	private String message;
	private String debitAccNo;
	private String creditAccNo;
	private double amount;
	
	
	
	 

}




