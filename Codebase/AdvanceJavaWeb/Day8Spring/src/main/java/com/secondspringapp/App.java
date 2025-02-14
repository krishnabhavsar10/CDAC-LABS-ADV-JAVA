package com.secondspringapp;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.secondspringapp.beans.Users;
import com.secondspringapp.config.ApplicationConfiguration;

public class App 
{
    public static void main( String[] args )
    {
        try(AnnotationConfigApplicationContext applicationContext =  new AnnotationConfigApplicationContext(ApplicationConfiguration.class)){
        	Users firstUser = (Users)applicationContext.getBean("objUser");
        	
        	Users secondUser = (Users)applicationContext.getBean("objUser");
        	
//        	firstUser.setUserName("Manit"); 
        	
        	System.out.println(firstUser.toString());
        	System.out.println("***************");
        	System.out.println(secondUser.toString());
        }
    }
}
