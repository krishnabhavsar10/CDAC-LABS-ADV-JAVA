package fi.hibernate;


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

/**
 * Servlet implementation class InitializeHibernate
 */
@WebServlet(
		loadOnStartup=1,
		urlPatterns={"/InitializeHibernate"})
public class InitializeHibernate extends HttpServlet {
	private static final long serialVersionUID = 1L;

    
	public void init(ServletConfig config) throws ServletException {
		super.init(config);

		Configuration hibernateConfiguration = new Configuration();
		
		Properties hibernateProperties = new Properties();
		hibernateProperties.setProperty("hibernate.connection.driver_class", "com.mysql.cj.jdbc.Driver");
		hibernateProperties.setProperty("hibernate.connection.url", "jdbc:mysql://localhost:3306/cdac_acts");
		hibernateProperties.setProperty("hibernate.connection.username", "acts");
		hibernateProperties.setProperty("hibernate.connection.password", "Cdac@123");
		hibernateProperties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL8Dialect");
		hibernateProperties.setProperty("hibernate.show_sql", "true");
		
		hibernateConfiguration.addProperties(hibernateProperties);
		
		hibernateConfiguration.addAnnotatedClass(Users.class);
		hibernateConfiguration.addAnnotatedClass(Category.class);
		
		SessionFactory hibernateFactory = hibernateConfiguration.buildSessionFactory();
		
		ServletContext application = getServletContext();
		application.setAttribute("hibernateFactory", hibernateFactory);
	}

}










