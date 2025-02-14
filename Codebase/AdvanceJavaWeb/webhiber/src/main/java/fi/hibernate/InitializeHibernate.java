package fi.hibernate;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import fi.hibernate.entity.Category;
import fi.hibernate.entity.Users;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;

@WebServlet(
		loadOnStartup = 1,
		urlPatterns={"/InitializeHibernate"})
public class InitializeHibernate extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		
		Configuration hibernateConfiguration = new Configuration();
		Properties hibernateProperties = new Properties();
		
		hibernateProperties.setProperty("hibernate.connection.driver_class", "com.mysql.cj.jdbc.Driver");
		hibernateProperties.setProperty("hibernate.connection.url", "jdbc:mysql://localhost:3306/advancejava");
		hibernateProperties.setProperty("hibernate.connection.username", "root");
		hibernateProperties.setProperty("hibernate.connection.password", "root");
		hibernateProperties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL8Dialect");
		hibernateProperties.setProperty("show_sql", "true");
		
//		hibernateProperties.load(new FileInputStream("application.properties"));
		hibernateConfiguration.addProperties(hibernateProperties);
		
		hibernateConfiguration.addAnnotatedClass(Users.class);
		hibernateConfiguration.addAnnotatedClass(Category.class);
		
		SessionFactory hibernateFactory = hibernateConfiguration.buildSessionFactory();
		
		ServletContext application = getServletContext();
		application.setAttribute("hibernateFactory", hibernateFactory);
	
	}

}