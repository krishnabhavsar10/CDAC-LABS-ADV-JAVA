package fi.hibernate;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
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

    	hibernateConfiguration.configure("first.cfg.xml");
    	
    	try(SessionFactory hibernateFactory = hibernateConfiguration.buildSessionFactory();
    	   	Session hibernateSession = hibernateFactory.openSession();)
    	{
        	//store(hibernateSession);
    		
    		Users objUser = hibernateSession.get(Users.class, "acts");
    		System.out.println(objUser.getUserName());
    		System.out.println(objUser.getName());
    		System.out.println(objUser.getEmail());
    		
    		
    		
    	}
    	catch(HibernateException excep)
    	{
    		excep.printStackTrace();
    	}
    	
    	
    }

	private static void store(Session hibernateSession) {
		Users objUser = new Users("test12a1","tests123","asdf","asdfsdaf@daskfjl.com");
		
		Transaction tx = hibernateSession.beginTransaction();
		    	
		hibernateSession.persist(objUser);
		
		tx.commit();
	}
}










