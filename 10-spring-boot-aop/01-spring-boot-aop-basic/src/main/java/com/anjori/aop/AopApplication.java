package com.anjori.aop;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.anjori.aop.dao.AccountDAO;

@SpringBootApplication
public class AopApplication {

	public static void main(String[] args) {
		SpringApplication.run(AopApplication.class, args);
	}


	@Bean
	public CommandLineRunner commandLineRunner(AccountDAO accountDAO){
		return runner ->{
			demoBeforeAdvice(accountDAO);

			// do it again
			System.out.println("\n Lets call it again.... \n");
			demoBeforeAdvice(accountDAO);
		};
	}


	private void demoBeforeAdvice(AccountDAO accountDAO) {
		// call the business method
		accountDAO.addAccount();
	}

}
