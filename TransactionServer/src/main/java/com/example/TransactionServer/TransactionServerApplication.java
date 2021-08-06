package com.example.TransactionServer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class TransactionServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(TransactionServerApplication.class, args);
	}

}
