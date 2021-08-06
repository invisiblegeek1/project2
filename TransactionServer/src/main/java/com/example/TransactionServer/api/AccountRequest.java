package com.example.TransactionServer.api;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class AccountRequest {
	private String accountHolderName;
	private String mobile;
	

}
