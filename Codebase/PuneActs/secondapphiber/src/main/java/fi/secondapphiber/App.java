package fi.secondapphiber;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import fi.hibernate.entity.Cards;
import fi.hibernate.entity.Category;
import fi.hibernate.entity.Products;
import fi.hibernate.entity.Transactions;

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
			hibernateConfiguration.addAnnotatedClass(Category.class);
			hibernateConfiguration.addAnnotatedClass(Products.class);
			hibernateConfiguration.addAnnotatedClass(Cards.class);
			hibernateConfiguration.addAnnotatedClass(Transactions.class);
			
			try(SessionFactory hibernateFactory = hibernateConfiguration.buildSessionFactory();
			   	Session hibernateSession = hibernateFactory.openSession();)
			{
				/*
				 * ProductId pid = new ProductId(1,2); Products objProduct =
				 * hibernateSession.get(Products.class, pid);
				 * System.out.println(objProduct.getPid().getCategoryId());
				 * System.out.println(objProduct.getPid().getProductId());
				 * System.out.println(objProduct.getProductName());
				 * System.out.println(objProduct.getProductDescription());
				 * System.out.println(objProduct.getProductPrice());
				 */
				
				/*
				 * Query<Category> queryCategory = hibernateSession.createQuery(
				 * "select object(oCategory) from Category oCategory where oCategory.categoryId=:cid"
				 * ,Category.class); queryCategory.setParameter("cid", 1);
				 */
				
				/*
				 * Query<Category> queryCategory =
				 * hibernateSession.createNamedQuery("allCategories",Category.class);
				 * 
				 * List<Category> listCategory = queryCategory.getResultList();
				 * 
				 * Consumer<Category> categoryConsumer = (objCategory)-> {
				 * System.out.println(objCategory.getCategoryId());
				 * System.out.println(objCategory.getCategoryName());
				 * System.out.println(objCategory.getCategoryDescription());
				 * System.out.println(objCategory.getCategoryImageUrl());
				 * System.out.println("***************************"); };
				 * 
				 * listCategory.forEach(categoryConsumer);
				 */
				
				/*
				 * Query<Products> productsByCategory =
				 * hibernateSession.createNamedQuery("productsByCategoryId",Products.class);
				 * productsByCategory.setParameter("cid", 1); List<Products> list =
				 * productsByCategory.getResultList(); list.forEach((oProd)->{
				 * System.out.println(oProd.getPid().getCategoryId());
				 * System.out.println(oProd.getPid().getProductId());
				 * System.out.println(oProd.getProductName());
				 * System.out.println(oProd.getProductDescription()); });
				 */
				
				Cards objCard = hibernateSession.get(Cards.class, 123456);
				
				System.out.println(objCard.getCardNo());
				System.out.println(objCard.getBalance());
				System.out.println("Your transactions are ");
				Set<Transactions> allTransactions = objCard.getTransactions();
				Iterator<Transactions> transactions= allTransactions.iterator();
				while(transactions.hasNext())
				{
					Transactions tx = transactions.next();
					System.out.println(tx.getTransactionId());
					System.out.println(tx.getAmount());
					System.out.println(tx.getTxDate());
					System.out.println(tx.getStatus());
					System.out.println("**********************************");
				}
				
				
				
				
			}
			catch(HibernateException excep)
			{
				excep.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    }
}
