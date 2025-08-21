package com.anjori.aop;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.anjori.aop.dao.AccountDAO;
import com.anjori.aop.dao.MembershipDAO;

@SpringBootApplication
public class AopApplication {

	public static void main(String[] args) {
		SpringApplication.run(AopApplication.class, args);
	}


	@Bean
	public CommandLineRunner commandLineRunner(AccountDAO accountDAO, MembershipDAO membershipDAO){
		return runner ->{
			demoTheAfterReturningAdvice(accountDAO);
		};

	}


	private void demoTheAfterReturningAdvice(AccountDAO accountDAO) {
	    // call the method to find the accounts
		List<Account> accounts = accountDAO.findAccounts();

		// display the accounts
		System.out.println("\nMain Program: demoTheAfterReturningAdvice");
		System.out.println("----");
		System.out.println(accounts);	
		
	}


	
}
