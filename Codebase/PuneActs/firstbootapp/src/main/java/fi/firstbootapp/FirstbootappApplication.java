package fi.firstbootapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import fi.firstbootapp.beans.Users;

@SpringBootApplication(scanBasePackages = {"fi.firstbootapp.beans"})
public class FirstbootappApplication implements CommandLineRunner 
{
	@Autowired
	Users objUser;
	
	public static void main(String[] args) {
		SpringApplication.run(FirstbootappApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		objUser.setUserName("fi");
		objUser.setPassword("cdac");
		System.out.println(objUser);
	}

}
