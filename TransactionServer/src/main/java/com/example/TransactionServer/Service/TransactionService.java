package com.example.TransactionServer.Service;

import javax.security.auth.login.AccountNotFoundException;

public interface TransactionService  {
	TransactionResponse TransactionSystem(String debitAccNo,String creditAccNo,double amount) throws AccountNotFoundException;

}
