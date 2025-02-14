package fi.firstbootmvc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication(scanBasePackages = {"fi.firstbootmvc.controllers"})
@EntityScan(basePackages = {"fi.firstbootmvc.entity"})
public class FirstbootmvcApplication {

	public static void main(String[] args) {
		SpringApplication.run(FirstbootmvcApplication.class, args);
	}

}
