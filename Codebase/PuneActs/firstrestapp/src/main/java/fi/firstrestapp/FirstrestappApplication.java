package fi.firstrestapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"fi.firstrestapp.controllers"})
public class FirstrestappApplication {

	public static void main(String[] args) {
		SpringApplication.run(FirstrestappApplication.class, args);
	}

}
