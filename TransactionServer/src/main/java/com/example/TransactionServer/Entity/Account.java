package com.example.TransactionServer.Entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GeneratorType;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity

public class Account {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	private int accountid;
	private String accountnumber;
	private double balance;
	private String accountHoldername;
	private String mobile;
	
	@JsonIgnore
	@OneToMany(mappedBy = "account")
	private List<Transaction> Transactions;
	

}

