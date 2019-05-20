package reiziger.annotatie.HibernateAnnotation;

import java.sql.Date;

import org.hibernate.Session;    
import org.hibernate.SessionFactory;    
import org.hibernate.Transaction;  
import org.hibernate.boot.Metadata;  
import org.hibernate.boot.MetadataSources;  
import org.hibernate.boot.registry.StandardServiceRegistry;  
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;




public class Main {

	public static void main(String[] args) {
		
		 StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();  
		 Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();  
		  
		SessionFactory factory = meta.getSessionFactoryBuilder().build();  
		Session session = factory.openSession();  
		Transaction t = session.beginTransaction();   
		            
		 //Aanmaken van Reiziger domein objecten
	      Reiziger reiziger1 = new Reiziger(12,"F","Ali","Hussein",Date.valueOf("1996-03-02"));
	      Reiziger reiziger2 = new Reiziger(13,"K","Ali","Hussein",Date.valueOf("1990-01-01"));
	      
	      
	     //objecten opslaan in database(save)
	      session.save(reiziger1);
	      session.save(reiziger2);
	      t.commit();  
	      
	    
	      // read
	      Reiziger r = session.find(Reiziger.class, reiziger1.getReizigerID());
	      System.out.println("Reiziger opgehaald: " + r.toString());
	      
	      // update
	       
	      Reiziger rr =  session.find(Reiziger.class, reiziger1.getReizigerID());
	        System.out.println("voor verandering: " + rr.toString());
	        rr.setAchternaam("megh");
	        session.save(rr);
	        t.commit();
	        System.out.println("na verandering: " + rr.toString());
	        
	      
	        //Delete
	      
	        Reiziger rrr = session.find(Reiziger.class, reiziger2.getReizigerID());
	        System.out.println("voor verwijderen: " + rrr.toString());
	        session.remove(rrr);
	        t.commit();
	        System.out.println("na verwijderen: " + rrr.toString());
	      
		    System.out.println("successfully saved");    
		    factory.close();  
		    session.close();    
		        
		}    
		

	}
