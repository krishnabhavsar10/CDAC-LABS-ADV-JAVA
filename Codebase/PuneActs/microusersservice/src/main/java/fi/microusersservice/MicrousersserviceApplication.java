package fi.microusersservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = {"fi.microusersservice.controllers",
											"fi.microusersservice.services"})
@EntityScan(basePackages = {"fi.microusersservice.entity"})
@EnableJpaRepositories(basePackages = {"fi.microusersservice.repository"})
public class MicrousersserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicrousersserviceApplication.class, args);
	}

}
