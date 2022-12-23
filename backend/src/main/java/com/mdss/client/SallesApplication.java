package com.mdss.client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@CrossOrigin("http://localhost:4200")
public class SallesApplication {

	@Value("${application.name}")
	private String ApplicationName;

	@GetMapping("/hello")
	public String HelloWorld(){
		return ApplicationName;
	}
	public static void main(String[] args) {
		SpringApplication.run(SallesApplication.class, args);
	}


}
