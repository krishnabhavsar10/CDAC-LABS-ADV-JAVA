package fi.restclientmvc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication(scanBasePackages = {"fi.restclientmvc.controllers"})
@EnableWebMvc
public class RestclientmvcApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestclientmvcApplication.class, args);
	}

}
