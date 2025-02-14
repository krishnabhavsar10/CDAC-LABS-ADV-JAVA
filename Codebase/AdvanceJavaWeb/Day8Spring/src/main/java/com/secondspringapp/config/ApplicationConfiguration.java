package com.secondspringapp.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;

import com.secondspringapp.beans.Users;

@Configuration
@ComponentScan(basePackages = {"com.secondspringapp.beans"})
@PropertySource("classpath:application.properties")
public class ApplicationConfiguration {

//	Taking Default Value From File
	@Bean
	@Scope(scopeName = "prototype")
	public Users objUsers(@Value("${default.username}") String username, @Value("${default.password}") String pwd) {
		return new Users(username, pwd);
	}
	
	

//  Trying to demo default ctor and how to use default values	
//	@Bean
//	public Users objUser(@Value("someDefaultUserName") String user, @Value("someDefaultPassword") String pwd) {
//		return new Users(user, pwd);
//	}
	
	
	
//  Manual Input 	
//	@Bean
//	@Scope(scopeName = "prototype") 
//	public Users objUser() {
//		return new Users("Krishna", "password"); // because of parameterised constructor
//	}
}
