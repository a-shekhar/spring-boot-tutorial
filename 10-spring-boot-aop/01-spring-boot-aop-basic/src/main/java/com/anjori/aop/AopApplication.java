package com.anjori.aop;

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
			demoBeforeAdvice(accountDAO, membershipDAO);

			// do it again
			//System.out.println("\n Lets call it again.... \n");
			//demoBeforeAdvice(accountDAO, membershipDAO);
		};
	}


	private void demoBeforeAdvice(AccountDAO accountDAO, MembershipDAO membershipDAO) {
		// call the business method
		Account account = new Account();
		accountDAO.addAccount(account, true);

		System.out.println();

		// call the membership business method
		membershipDAO.addSillyMethod();
	}

}
