package com.handson.usecase;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication
public class UseCaseApplication {

	public static void main(String[] args) {
		SpringApplication.run(UseCaseApplication.class, args);
	}

}
