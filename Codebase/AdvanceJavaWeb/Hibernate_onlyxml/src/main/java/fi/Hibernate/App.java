package fi.Hibernate;

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
        
        try(
        		SessionFactory hibernateFactory = hibernateConfiguration.buildSessionFactory();
        		Session hibernateSession = hibernateFactory.openSession() 
        	){
        	
        	//storeData(hibernateSession);
        	
        	Users objUser = hibernateSession.get(Users.class, "krishna"); // get is like select query see the console
        	System.out.println(objUser.toString()); 
        	
        }
        catch(HibernateException excep) {
        	excep.printStackTrace();
        }
    }

	private static void storeData(Session hibernateSession) {
		Users objUser = new Users("manit", "manit", "manit","manit@manit.com");
		
		// Because we are inserting we have to create a Transaction
		Transaction tx = hibernateSession.beginTransaction();
		
		hibernateSession.persist(objUser); // basically a insert query internally is fired that you can see in console
		
		tx.commit(); // see the console you can see the autocommit is false so we have to do this
		
	}
    
    
}
