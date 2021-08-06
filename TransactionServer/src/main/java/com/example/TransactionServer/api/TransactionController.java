package com.example.TransactionServer.api;

import javax.security.auth.login.AccountNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;

import com.example.TransactionServer.Exceptions.InsufficientBalanceException;
import com.example.TransactionServer.Service.TransactionResponse;
import com.example.TransactionServer.Service.TransactionService;

@RestController
public class TransactionController {

    private TransactionService transferService;

    @Autowired
    public TransactionController(TransactionService transferService) {
        this.transferService = transferService;
    }

    @PostMapping(
            value = "/api/txr",
            consumes = {"application/json","application/xml"},
            produces = {"application/json","application/xml"}
    )
    public ResponseEntity<?> doTxr(@RequestBody TransactionRequest request) throws AccountNotFoundException{
       TransactionResponse txr= transferService.TransactionSystem(request.getDebitAccNo(),request.getCreditAccNo(),request.getAmount());
//       TxrResponse response=new TxrResponse();
//       response.setMessage(txrStatus.getStatus().name());
       return ResponseEntity.ok().body(txr); // 200
    }
//
    @ResponseStatus(HttpStatus.NOT_FOUND)// 404
    @ExceptionHandler(value = {AccountNotFoundException.class})
    public TransactionResponse noAccount(Throwable t){
    	TransactionResponse response=new TransactionResponse();
        response.setMessage("account not found");
        return response;
    }
    
    
    

    @ResponseStatus(HttpStatus.BAD_REQUEST)// 400
    @ExceptionHandler(value = {InsufficientBalanceException.class})
    public TransactionResponse noEnoughBalance(Throwable t){
    	TransactionResponse response=new TransactionResponse();
        response.setMessage("no enough balance");
        return response;
    }

}
