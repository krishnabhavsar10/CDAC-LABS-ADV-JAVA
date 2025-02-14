package fi.hibernate_pureannotations;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
     	
        Configuration hibernateConfiguration = new Configuration();
       
    	try {
    		Properties configProperties = new Properties();
			configProperties.load(new FileInputStream("application.properties"));
			
			hibernateConfiguration.addProperties(configProperties);
			
			hibernateConfiguration.addAnnotatedClass(Users.class);
			
			try(
					SessionFactory hibernateFactory = hibernateConfiguration.buildSessionFactory();
					Session hibernateSession = hibernateFactory.openSession();
					){
				Users objUsers = hibernateSession.get(Users.class, "krishna");
				System.out.println(objUsers.toString());
			}
			catch(HibernateException e) {
				e.printStackTrace();
			}
			
		} catch (IOException e) {

			e.printStackTrace();
		}
    	
       
    }
}
