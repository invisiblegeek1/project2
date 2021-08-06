package com.example.TransactionServer.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.TransactionServer.Entity.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, Integer>{
	
	@Query("select a from Account a where a.accountnumber=:AccNo")
	Optional<Account> findByAccNo(@Param("AccNo")String AccNo);

}
