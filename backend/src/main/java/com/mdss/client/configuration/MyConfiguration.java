package com.mdss.client.configuration;

import com.mdss.client.SallesApplication;
import com.mdss.client.model.Client;
import com.mdss.client.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("dev")
public class MyConfiguration {

    @Bean
    public CommandLineRunner exec(@Autowired ClientRepository repository){
        return args ->{
            Client client = new Client();
            client.setCpf("33550781822");
            client.setName("Marcelo Soares");
        };
    }

    public static void main(String[] args) {
        SpringApplication.run(SallesApplication.class, args);
    }
}
