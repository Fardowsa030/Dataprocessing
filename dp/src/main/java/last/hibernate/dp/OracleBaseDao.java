package last.hibernate.dp;



import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class OracleBaseDao  {
	private static String orclcfg = "nl.hu.ict.jpa.oracle";
    private static EntityManagerFactory entityManagerFactory;
	
	protected EntityManager getConnection() {
	    
        EntityManager em = null;
        try {
            entityManagerFactory = Persistence.createEntityManagerFactory(orclcfg);
            em = entityManagerFactory.createEntityManager();
            return em;
        } catch (Throwable ex) {
            System.err.println("Failed to create sessionFactory object." + ex);
            throw new ExceptionInInitializerError(ex);
        }
		
	}

		

}
	

