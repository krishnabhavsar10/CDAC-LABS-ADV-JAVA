package com.TicketAssignment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = {"com.Ticket.controllers", "com.Ticket.services"})
@EntityScan(basePackages = {"com.Ticket.entity"})
@EnableJpaRepositories(basePackages = {"com.Ticket.repository"})
public class TicketAssignmentApplication {

	public static void main(String[] args) {
		SpringApplication.run(TicketAssignmentApplication.class, args);
	}

}
