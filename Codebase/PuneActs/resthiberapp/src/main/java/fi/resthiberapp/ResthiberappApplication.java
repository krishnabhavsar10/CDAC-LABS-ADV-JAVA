package fi.resthiberapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = {"fi.resthiberapp.controllers",
											"fi.resthiberapp.services"})
@EntityScan(basePackages = {"fi.resthiberapp.entity"})
@EnableJpaRepositories(basePackages = {"fi.resthiberapp.repositories"})
public class ResthiberappApplication {

	public static void main(String[] args) {
		SpringApplication.run(ResthiberappApplication.class, args);
	}

}
