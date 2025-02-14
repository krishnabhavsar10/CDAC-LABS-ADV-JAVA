package fi.microuserservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = {"fi.microuserservice.controllers", 
											"fi.microuserservice.services"})
@EntityScan(basePackages = {"fi.microuserservice.entity"})
@EnableJpaRepositories(basePackages = {"fi.microuserservice.repository"})
public class MicrouserserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicrouserserviceApplication.class, args);
	}

}
