package fi.spring;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        ClassPathXmlApplicationContext applicationContext = 
        		new ClassPathXmlApplicationContext("first-beans-app.xml");
        
        Users objUser = (Users)applicationContext.getBean("objUser");
        
        System.out.println(objUser.getUserName());
        System.out.println(objUser.getPassword());
        
        
    }
}
