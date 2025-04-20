package com.ey.banking.tms.transinit;

import com.ey.banking.tms.transinit.controller.TransInitController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableCaching
public class TransactionInitializerApplication {

	// The main entry point for the Spring Boot application
	// It starts the application by calling SpringApplication.run() method
	// with the TransactionInitializerApplication class as an argument.
	// This class serves as the configuration and bootstrap for the application.
	// It also enables caching in the application.


	public static void main(String[] args) {
		SpringApplication.run(TransactionInitializerApplication.class, args);
	}

}
