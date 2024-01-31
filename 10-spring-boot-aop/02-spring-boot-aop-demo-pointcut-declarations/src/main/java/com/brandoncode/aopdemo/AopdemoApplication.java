package com.brandoncode.aopdemo;

import com.brandoncode.aopdemo.dao.AccountDAO;
import com.brandoncode.aopdemo.dao.AccountDaoImpl;
import com.brandoncode.aopdemo.dao.MembershipDAO;
import com.brandoncode.aopdemo.service.TrafficFortuneService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class AopdemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(AopdemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner (AccountDAO accountDAO,
												MembershipDAO membershipDAO,
												TrafficFortuneService trafficFortuneService) {
		return runner -> {
//			demoTheBeforeAdvice(accountDAO, membershipDAO);
//			demoTheAfterReturningAdvice(accountDAO);
//			demoTheAfterThrowingAdvice(accountDAO);
//			demoTheAfterAdvice(accountDAO);
//			demoTheAroundAdvice(trafficFortuneService);
//			demoTheAroundAdviceHandleException(trafficFortuneService);
			demoTheAroundAdviceRethrowException(trafficFortuneService);
		};
	}

	private void demoTheAroundAdviceRethrowException(TrafficFortuneService trafficFortuneService) {
		System.out.println("\ndemoTheAroundAdviceRethrowException");

		System.out.println("Calling getFortune()");

		boolean tripWire = true;
		System.out.println("\nMy fortune is: " + trafficFortuneService.getFortune(tripWire));

		System.out.println("Finished");
	}

	private void demoTheAroundAdviceHandleException(TrafficFortuneService trafficFortuneService) {
		System.out.println("\ndemoTheAroundAdviceHandleException");

		System.out.println("Calling getFortune()");

		boolean tripWire = true;
		System.out.println("\nMy fortune is: " + trafficFortuneService.getFortune(tripWire));

		System.out.println("Finished");
	}

	private void demoTheAroundAdvice(TrafficFortuneService trafficFortuneService) {
		System.out.println("\ndemoTheAroundAdvice");

		System.out.println("Calling getFortune()");

		System.out.println("\nMy fortune is: " + trafficFortuneService.getFortune());

		System.out.println("Finished");
	}

	private void demoTheAfterAdvice(AccountDAO accountDAO) {
		List<Account> list = null;

		try{
			boolean tripWire = false;
			list = accountDAO.findAccounts(tripWire);
		} catch(Exception e) {
			System.out.println("\nCaught exception: " + e);
		}
		System.out.println("\ndemoTheAfterThrowingAdvice(): ");
		System.out.println(list);
	}

	private void demoTheAfterThrowingAdvice(AccountDAO accountDAO) {
		List<Account> list = null;

		try{
			boolean tripWire = true;
			list = accountDAO.findAccounts(tripWire);
		} catch(Exception e) {
			System.out.println("\nCaught exception: " + e);
		}
		System.out.println("\ndemoTheAfterThrowingAdvice(): ");
		System.out.println(list);
	}

	private void demoTheAfterReturningAdvice(AccountDAO accountDAO) {
		List<Account> list = accountDAO.findAccounts();

		System.out.println("\ndemoTheAfterReturningAdvice(): ");
		System.out.println(list);
	}

	private void demoTheBeforeAdvice(AccountDAO accountDAO, MembershipDAO membershipDAO) {
		accountDAO.addAccount(new Account(
				"Brandon", "Platinum"
		), true);


		System.out.println();
		membershipDAO.addMemberBember();

		System.out.println();
		accountDAO.doWork();

		System.out.println();
		membershipDAO.goToSleep();

		System.out.println();
		accountDAO.getName();

		System.out.println();
		accountDAO.setName("test");
	}

}
