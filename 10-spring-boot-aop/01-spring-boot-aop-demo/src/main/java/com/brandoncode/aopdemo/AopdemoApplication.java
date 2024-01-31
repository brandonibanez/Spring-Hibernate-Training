package com.brandoncode.aopdemo;

import com.brandoncode.aopdemo.dao.AccountDAO;
import com.brandoncode.aopdemo.dao.MembershipDAO;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AopdemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(AopdemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner (AccountDAO accountDAO, MembershipDAO membershipDAO) {
		return runner -> {
			demoTheBeforeAdvice(accountDAO, membershipDAO);
		};
	}
	private void demoTheBeforeAdvice(AccountDAO accountDAO, MembershipDAO membershipDAO) {
		accountDAO.addAccount(new Account(), true);

		System.out.println();

		membershipDAO.addMemberBember();

		System.out.println();

		accountDAO.doWork();

		System.out.println();

		membershipDAO.goToSleep();
	}

}
