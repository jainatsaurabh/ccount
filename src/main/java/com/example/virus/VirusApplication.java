package com.example.virus;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "com.example.virus")
@EnableJpaRepositories("com.example.virus.repo")
public class VirusApplication {
	static {

		System.out.println("VirusApplication............................................");
	}

	public static void main(String[] args) {
		SpringApplication.run(VirusApplication.class, args);
	}

}
