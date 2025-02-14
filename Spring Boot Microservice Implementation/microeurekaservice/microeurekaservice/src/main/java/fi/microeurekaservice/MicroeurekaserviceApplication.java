package fi.microeurekaservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class MicroeurekaserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroeurekaserviceApplication.class, args);
	}

}
