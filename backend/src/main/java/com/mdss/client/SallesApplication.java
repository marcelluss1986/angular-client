package com.mdss.client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class SallesApplication {

	@Value("${application.name}")
	private String ApplicationName;

	public static void main(String[] args) {
		SpringApplication.run(SallesApplication.class, args);
	}


}
