package fi.secondspringapp.config;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;

import fi.secondspringapp.beans.Users;

@Configuration
@PropertySource("classpath:application.properties")
public class ApplicationConfiguration 
{
	@Bean
	
	public Users objUser(@Value("${default.username}") String user,@Value("${default.password}") String pwd)
	{
		return new Users(user,pwd);
	}
	
	
}
