package com.example.TransactionServer.api;

import com.example.TransactionServer.Service.ResponseStatus;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class AccountResponse {
	
	private ResponseStatus status;
	private String message;
	

}
