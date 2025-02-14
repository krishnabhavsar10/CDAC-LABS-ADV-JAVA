package com.ticketgenerator.ticketgenerate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = {"controllers" , "services"})
@EnableJpaRepositories(basePackages = {"repositories"})
@EntityScan(basePackages = {"entity"})
public class TicketgenerateApplication {

	public static void main(String[] args) {
		SpringApplication.run(TicketgenerateApplication.class, args);
	}

}
