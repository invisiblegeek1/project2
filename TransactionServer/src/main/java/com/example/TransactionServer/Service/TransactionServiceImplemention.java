package com.example.TransactionServer.Service;

import java.util.Date;
import java.util.Optional;

import javax.security.auth.login.AccountNotFoundException;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.example.TransactionServer.Entity.Account;
import com.example.TransactionServer.Entity.Transaction;
import com.example.TransactionServer.Entity.TxnType;
import com.example.TransactionServer.Exceptions.InsufficientBalanceException;
import com.example.TransactionServer.Repository.AccountRepository;
import com.example.TransactionServer.Repository.TransactionRepository;

@Service
public class TransactionServiceImplemention implements TransactionService{
	private AccountRepository accountRepository;
	private TransactionRepository transcationRepository;
	
	public TransactionServiceImplemention(AccountRepository accountRepository,
			TransactionRepository transcationRepository) {
		
		this.accountRepository = accountRepository;
		this.transcationRepository = transcationRepository;
	}
	@Transactional
	@Override
	public TransactionResponse TransactionSystem(String debitAccNo,String creditAccNo,double amount) throws AccountNotFoundException{
		
		Optional<Account> optionalDebitAccount = accountRepository.findByAccNo(debitAccNo);
		
		Account debitAccount=optionalDebitAccount.orElseThrow(()->new AccountNotFoundException("There is no account  "));
		
		
		Optional<Account> optionalCreditAccount = accountRepository.findByAccNo(creditAccNo);
		
		Account creditAccount=optionalCreditAccount.orElseThrow(()->new AccountNotFoundException("There is no account  "));
		
		if(debitAccount.getBalance()<amount)
			throw new InsufficientBalanceException("Insufficient balance");
		
		debitAccount.setBalance(debitAccount.getBalance()-amount);
		creditAccount.setBalance(creditAccount.getBalance()+amount);
		
		
		Transaction debitTransaction= new Transaction();
		debitTransaction.setType(TxnType.DEBIT);
		debitTransaction.setAccount(debitAccount);
		debitTransaction.setAmount(amount);
		debitTransaction.setDate(new Date());
		
		Transaction creditTransaction= new Transaction();
		creditTransaction.setType(TxnType.CREDIT);
		creditTransaction.setAccount(creditAccount);
		creditTransaction.setAmount(amount);
		creditTransaction.setDate(new Date());
		
		accountRepository.save(debitAccount);
		accountRepository.save(debitAccount);
		
		transcationRepository.save(debitTransaction);
		transcationRepository.save(creditTransaction);

		
		
		
		
		
		
		return new TransactionResponse(ResponseStatus.SUCCESS,"Transcation Success", debitAccNo,creditAccNo,amount);
		
	}
	

}
