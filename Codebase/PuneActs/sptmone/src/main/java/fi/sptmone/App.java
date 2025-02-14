package fi.sptmone;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        AnnotationConfigApplicationContext springContext = new AnnotationConfigApplicationContext(BeanConfig.class);
        
        FirstBean bean = (FirstBean)springContext.getBean("firstBean");
        System.out.println(bean.getUserName());
        System.out.println(bean.getPassword());
    }
}
