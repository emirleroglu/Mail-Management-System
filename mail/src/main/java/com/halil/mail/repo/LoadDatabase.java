package com.halil.mail.repo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.halil.mail.entity.Mail;


@Configuration
public class LoadDatabase {
	private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

	@Bean
	CommandLineRunner initDatabase(MailRepository repo) {

		return args -> {
			log.info("Preloading "+repo.save(new Mail("xxx.example@gmail.com")));
			log.info("Preloading " + repo.save(new Mail("example@gmail.com")));
		};
	}
}
