package com.example.forohub;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder; // Asegúrese de tener este import

@SpringBootApplication
public class ForHubApplication {

	public static void main(String[] args) {

		SpringApplication.run(ForHubApplication.class, args);
	}

}