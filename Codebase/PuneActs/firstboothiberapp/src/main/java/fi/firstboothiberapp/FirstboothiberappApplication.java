package fi.firstboothiberapp;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import fi.firstboothiberapp.entity.Users;

@SpringBootApplication
@EntityScan(basePackages = {"fi.firstboothiberapp.entity"})
public class FirstboothiberappApplication implements CommandLineRunner
{
	@Autowired
	SessionFactory hibernateFactory;

	public static void main(String[] args) {
		SpringApplication.run(FirstboothiberappApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		try(Session hibernateSession = hibernateFactory.openSession())
		{
			Users objUser = (Users)hibernateSession.get(Users.class, "acts");
			System.out.println(objUser);
		}
		
		
	}

}
