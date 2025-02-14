package fi.secondspringapp;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import fi.secondspringapp.beans.Users;
import fi.secondspringapp.config.ApplicationConfiguration;

public class App 
{
    public static void main( String[] args )
    {
    	try(AnnotationConfigApplicationContext applicationContext = 
        			new AnnotationConfigApplicationContext(ApplicationConfiguration.class))
        {
        	Users objUser = (Users)applicationContext.getBean("objUser");
        	
        	Users secondUsers = (Users)applicationContext.getBean("objUser");
        	
        	
        	
        	System.out.println(objUser.getUserName());
        	System.out.println(objUser.getPassword());
        	System.out.println("*****************************");
        	System.out.println(secondUsers.getUserName());
        	System.out.println(secondUsers.getPassword());

        }
    }
}









