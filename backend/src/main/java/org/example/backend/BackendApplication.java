package org.example.backend;

import org.example.backend.ai.AccountRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class BackendApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(BackendApplication.class, args);
		initAccountToDatabase(context);

	}
	public static void initAccountToDatabase(ConfigurableApplicationContext context) {
		var accountRepository = context.getBean(AccountRepository.class);
		accountRepository.save(new Account("John Doe", 30));
		accountRepository.save(new Account("Jane Doe", 25));
	}

}
