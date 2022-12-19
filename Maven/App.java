package com.first;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.sarbopojo.Movie;

import jakarta.transaction.HeuristicMixedException;
import jakarta.transaction.HeuristicRollbackException;
import jakarta.transaction.RollbackException;
import jakarta.transaction.SystemException;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws SecurityException, IllegalStateException, RollbackException, HeuristicMixedException, HeuristicRollbackException, SystemException
    {
        System.out.println( "Hello World!" );
        Configuration cfg=  new Configuration();
	     cfg.configure("hibernate.cfg.xml");
	     SessionFactory factory = cfg.buildSessionFactory();
	     
	     //creating object and set values
	     Movie m=new Movie();
	     m.setId(2);
	     m.setMovieName("pathan");
	     m.setActor("srk");
	     Session session =factory.openSession();
	    
	     
	     System.out.println("after setting");
	     org.hibernate.Transaction tx=session.beginTransaction();
	     //save  
        session.save(m);
        
	     tx.commit();
	     session.close();
	     factory.close();
     
    }
}
