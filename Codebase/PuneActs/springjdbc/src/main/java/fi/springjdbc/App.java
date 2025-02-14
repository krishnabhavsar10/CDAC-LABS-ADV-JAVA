package fi.springjdbc;

import java.util.Iterator;
import java.util.Scanner;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import fi.springjdbc.beans.Users;
import fi.springjdbc.config.ApplicationConfiguration;
import fi.springjdbc.dao.UsersDAO;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        try(AnnotationConfigApplicationContext applicationContext=
        		new AnnotationConfigApplicationContext(ApplicationConfiguration.class);
        		Scanner scanner = new Scanner(System.in))
        {
        	UsersDAO dao = (UsersDAO) applicationContext.getBean("userDAO");
        	
			/*
			 * System.out.println("Enter username,name,email"); String userName =
			 * scanner.next(); String password = scanner.next(); String name =
			 * scanner.next(); String email = scanner.next();
			 * 
			 * boolean status = dao.registerUser(userName, password, name, email);
			 * if(status) System.out.println("User registered");
			 */
        	
        	Iterator<Users> allUsers = dao.getAllUsers();
        	while(allUsers.hasNext())
        	{
        		Users objUser = allUsers.next();
        		System.out.println(objUser);
        	}
        	
        	
        	
        	
        }
    }
}
