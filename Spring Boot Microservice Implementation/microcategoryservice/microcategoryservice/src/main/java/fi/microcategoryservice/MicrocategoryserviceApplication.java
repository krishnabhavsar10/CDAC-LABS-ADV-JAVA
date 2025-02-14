package fi.microcategoryservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = {"fi.microcategoryservice.services", "fi.microcategoryservice.controllers"})
@EntityScan(basePackages = {"fi.microcategoryservice.entity"})
@EnableJpaRepositories(basePackages = {"fi.microcategoryservice.repository"})
public class MicrocategoryserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicrocategoryserviceApplication.class, args);
	}

}
