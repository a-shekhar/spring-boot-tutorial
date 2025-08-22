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
			//demoTheAfterThrowingAdvice(accountDAO);
			demoTheAfterAdvice(accountDAO);
		};

	}



	private void demoTheAfterAdvice(AccountDAO accountDAO) {
		List<Account> accounts = null;
		try{
			// add a boolean flag to simulate exception
			boolean tripWire = true;
	    	// call the method to find the accounts
		  	accounts = accountDAO.findAccounts(tripWire);
		} catch(Exception e){
			System.out.println("\n\nMain Program:... Caught Exception: " + e);
		}

		// display the accounts
		System.out.println("\nMain Program: demoTheAfterAdvice");
		System.out.println("----");
		System.out.println(accounts);	

		System.out.println("\n\nCalling findAccounts again without exception");
		accounts = accountDAO.findAccounts(false);
		System.out.println(accounts);
		
	}


	private void demoTheAfterThrowingAdvice(AccountDAO accountDAO) {
		List<Account> accounts = null;
		try{
			// add a boolean flag to simulate exception
			boolean tripWire = true;
	    	// call the method to find the accounts
		  	accounts = accountDAO.findAccounts(tripWire);
		} catch(Exception e){
			System.out.println("\n\nMain Program:... Caught Exception: " + e);
		}

		// display the accounts
		System.out.println("\nMain Program: demoTheAfterThrowingAdvice");
		System.out.println("----");
		System.out.println(accounts);	
		
	}


	
}
