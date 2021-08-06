package com.example.TransactionServer.api;

import javax.xml.bind.annotation.XmlRootElement;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@XmlRootElement(name="TransactioRequest")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class TransactionRequest {
	private String debitAccNo;
	private String creditAccNo;
	private double amount;
	
	
	
	

}
