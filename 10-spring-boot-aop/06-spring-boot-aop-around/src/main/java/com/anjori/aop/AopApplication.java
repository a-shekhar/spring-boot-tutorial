package com.anjori.aop;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.anjori.aop.service.TrafficFortuneService;

@SpringBootApplication
public class AopApplication {

	public static void main(String[] args) {
		SpringApplication.run(AopApplication.class, args);
	}


	@Bean
	public CommandLineRunner commandLineRunner(TrafficFortuneService fortuneService) {
		return runner ->{
			//demoTheAroundAdvice(fortuneService);
			demoTheAroundAdviceHandleException(fortuneService);
		};

	}


	private void demoTheAroundAdviceHandleException(TrafficFortuneService fortuneService) {
			System.out.println("\nMain Program: demoTheAroundAdvice");
		System.out.println("Calling getFortune");

		// Call method to get fortune
		boolean tripWire = true;
		String data = fortuneService.getFortune(tripWire);

		System.out.println("My fortune is: " + data);

		System.out.println("Finished");
		System.out.println("--------------------------------------------------");
	}


	private void demoTheAroundAdvice(TrafficFortuneService fortuneService) {
		System.out.println("\nMain Program: demoTheAroundAdvice");
		System.out.println("Calling getFortune");

		// Call method to get fortune
		String data = fortuneService.getFortune();

		System.out.println("My fortune is: " + data);

		System.out.println("Finished");
		System.out.println("--------------------------------------------------");
	}	
}
