package fi.bootsecuredform;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class CustomBasicConfigurator 
{
	@Bean
	public PasswordEncoder passwordEncoder()
	{
		return new BCryptPasswordEncoder();
	}
	
	@Bean 
	public UserDetailsService userDetailsService(PasswordEncoder encoder)
	{
		
		UserDetails user = 
				User.withUsername("acts")
				.password(encoder.encode("acts@123"))
				.roles("USER")
				.build();
		
		UserDetails admin = 
				User.withUsername("actsadmin")
				.password(encoder.encode("acts@123"))
				.roles("USER","ADMIN")
				.build();
		
		return new InMemoryUserDetailsManager(user,admin);
	}
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception
	{
		http
			.csrf(csrf -> csrf.disable())
			.authorizeHttpRequests(auth ->
				auth.requestMatchers("/default/**").permitAll()
				.requestMatchers("/users/**")
				.authenticated())
				.httpBasic();
		return http.build();			
	}	
}












