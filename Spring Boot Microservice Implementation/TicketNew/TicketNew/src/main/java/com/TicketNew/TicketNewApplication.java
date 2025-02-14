package com.TicketNew;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = {"com.ticket.services", "com.ticket.controllers"})
@EntityScan(basePackages = "com.ticket.entity")
@EnableJpaRepositories(basePackages = "com.ticket.repository")
public class TicketNewApplication {

	public static void main(String[] args) {
		SpringApplication.run(TicketNewApplication.class, args);
	}

}
