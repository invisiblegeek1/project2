package com.example.TransactionServer.api;

import java.util.List;

import javax.security.auth.login.AccountNotFoundException;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.TransactionServer.Entity.Account;
import com.example.TransactionServer.Entity.Transaction;
import com.example.TransactionServer.Repository.AccountRepository;
import com.example.TransactionServer.Repository.TransactionRepository;
import com.example.TransactionServer.Service.ResponseStatus;



@CrossOrigin(origins = {"*"})
@RestController
public class AccountController {

    private AccountRepository accountRepository;
    private TransactionRepository txnRepository;

    public AccountController(AccountRepository accountRepository, TransactionRepository txnRepository) {
        this.accountRepository = accountRepository;
        this.txnRepository = txnRepository;
    }
    @PostMapping(
    		value="/api/account/new",
    		consumes= {"application/json","application/xml"},
    		produces= {"application/json","application/xml"}
    		
    		)
    public ResponseEntity<?> createAccount(@RequestBody AccountRequest request){
    	String IFSC_CODE="6023";
    	String AccNo=IFSC_CODE+request.getMobile();
    	
    	
    	
    	Account newAccount= new Account();
    	newAccount.setAccountHoldername(request.getAccountHolderName());
    	newAccount.setAccountnumber(AccNo);
    	newAccount.setMobile(request.getMobile());
    	newAccount.setBalance(5000);
    	
    	Account accountResponse=accountRepository.save(newAccount);
    	AccountResponse response=new  AccountResponse();
    	response.setStatus(ResponseStatus.SUCCESS);
    	response.setMessage("Hello "+request.getAccountHolderName()+", Your Account Has Created Sucesfully");
    	
    	
    	return ResponseEntity.ok().body(response);
    	
    }
    
    

    @GetMapping("/api/accounts")
    public List<Account> getAll(){
        return accountRepository.findAll();
    }

    @GetMapping("/api/accounts/{number}")
    public Account getOne(@PathVariable String number) throws AccountNotFoundException{
        return accountRepository.findByAccNo(number).orElseThrow(()->new AccountNotFoundException("There is no account  "));
    }


    @GetMapping("/api/accounts/{number}/txns")
    public List<Transaction> getTxns(@PathVariable String number,@RequestParam(name="limit",required = false) Integer limit){
        return accountRepository.findByAccNo(number).get().getTransactions();
    }


    @GetMapping("/api/txns/{txnId}")
    public Transaction getTxn(@PathVariable int txnId){
        return txnRepository.findById(txnId).get();
    }

}
