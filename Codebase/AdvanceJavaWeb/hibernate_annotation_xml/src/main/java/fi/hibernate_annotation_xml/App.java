package fi.hibernate_annotation_xml;

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
        		Session hibernateSession = hibernateFactory.openSession();
        		){
        	
        	// Select
        	Users objUser = hibernateSession.get(Users.class, "krishna");
        	System.out.println(objUser.toString());
        	
        	
        	// Insertion
        	Users objUser2 = new Users("sas","dsa","dsad","dada@sada.com");
        	
        	Transaction tx = hibernateSession.beginTransaction();
        	
        	hibernateSession.persist(objUser2);
        	
        	tx.commit();
        	
        	
        }
    }
}
