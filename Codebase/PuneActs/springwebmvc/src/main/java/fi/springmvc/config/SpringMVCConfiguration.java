package fi.springmvc.config;

import java.util.Locale;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import fi.springjdbc.dao.UsersDAO;
import fi.springjdbc.dao.UsersDAOImpl;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"fi.springmvc.controllers","fi.springmvc.beans"})
@PropertySource("classpath:application.properties")
public class SpringMVCConfiguration implements WebMvcConfigurer 
{
	@Autowired
	Environment env;
	
	@Bean
	public DataSource dataSource()
	{
		String driver = env.getProperty("db.connection.driverclass");
		String url = env.getProperty("db.connection.url");
		String user = env.getProperty("db.connection.username");
		String pwd = env.getProperty("db.connection.password");
		
		DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setDriverClassName(driver);
		ds.setUrl(url);
		ds.setUsername(user);
		ds.setPassword(pwd);
		
		return ds;		
	}
	
	@Bean
	public JdbcTemplate jdbcTemplate(DataSource dataSource)
	{
		return new JdbcTemplate(dataSource);
	}

	@Bean
	public UsersDAO userDAO()
	{
		return new UsersDAOImpl();
	}
	@Bean
	public ViewResolver viewResolver()
	{
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		
		viewResolver.setPrefix("/WEB-INF/views/");
		viewResolver.setSuffix(".jsp");
		
		return viewResolver;		
	}
	
	@Bean
	public LocaleResolver localeResolver()
	{
		return new CookieLocaleResolver();
	}
	
	@Bean
	public LocaleChangeInterceptor localeInterceptor()
	{
		LocaleChangeInterceptor interceptor = new LocaleChangeInterceptor();
		interceptor.setParamName("lang");
		return interceptor;
	}
	
	@Bean
	public ResourceBundleMessageSource messageSource()
	{
		ResourceBundleMessageSource messageSource= new ResourceBundleMessageSource();
		messageSource.setBasename("messages");
		messageSource.setDefaultLocale(Locale.ENGLISH);
		messageSource.setDefaultEncoding("UTF-8");
		
		return messageSource;		
	}
	
	@Override
	public void addInterceptors(InterceptorRegistry registry)
	{
		registry.addInterceptor(localeInterceptor());
	}
	
}










