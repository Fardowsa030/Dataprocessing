package hu.nl.hibernate;

import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class MainReiziger {
	private static SessionFactory factory;
	  public static void main(String[] args) throws SQLException, ParseException {
	      try {
	        factory = new Configuration().configure().buildSessionFactory();
	      } catch (Throwable ex) {
	        System.err.println("Failed to create sessionFactory object." + ex);
	        throw new ExceptionInInitializerError(ex);
	      }
	      Session session = factory.openSession();
	      Transaction t = session.beginTransaction();
          
	    //Aanmaken van Reiziger domein objecten
	      Reiziger reiziger1 = new Reiziger(12,"F","Ali","Hussein",Date.valueOf("1996-03-02"));
	      Reiziger reiziger2 = new Reiziger(13,"K","Ali","Hussein",Date.valueOf("1990-01-01"));
	      
	      
	      //objecten opslaan in database
	      session.save(reiziger1);
	      session.save(reiziger2);
	      t.commit();  
	      
	    
	      // read
	      Reiziger r = session.find(Reiziger.class, reiziger1.getReizigerID());
	      System.out.println("Reiziger opgehaald: " + r.toString());
	      
	      // update
	       
	      Reiziger rr =  session.find(Reiziger.class, reiziger1.getReizigerID());
	        System.out.println("voor verandering: " + rr.toString());
	        rr.setAchternaam("Test");
	        session.save(rr);
	        t.commit();
	        System.out.println("na verandering: " + rr.toString());
	        
	      
	      //Delete
	     
	        Reiziger rrr = session.find(Reiziger.class, reiziger2.getReizigerID());
	        System.out.println("voor verwijderen: " + rrr.toString());
	        session.remove(rrr);
	        t.commit();
	        System.out.println("na verwijderen: " + rrr.toString());
	      

	    
	      

	      System.out.println("success");    
	      factory.close();  
	      session.close();  
	      
	  }

}
