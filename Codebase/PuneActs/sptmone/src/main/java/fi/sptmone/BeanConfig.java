package fi.sptmone;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:application.properties")
public class BeanConfig {
	@Bean
	public FirstBean firstBean(@Value("${users.username}") String userName,@Value("${users.password}") String password)
	{
		
		return new FirstBean(userName,password);
	}
}
