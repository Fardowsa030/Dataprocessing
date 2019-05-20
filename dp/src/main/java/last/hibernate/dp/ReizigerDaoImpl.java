package last.hibernate.dp;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;


public class ReizigerDaoImpl extends OracleBaseDao implements ReizigerDao{

	private EntityManager emr = super.getConnection();
	
	
	@SuppressWarnings("unchecked")
	public List<Reiziger> getReizigers() {
		
		Query query = emr.createQuery("FROM " + Reiziger.class.getName());
		
		return (List<Reiziger>) query.getResultList();
	}
	
	public Reiziger find(int id) {
		Reiziger reiziger = null;
		reiziger = emr.find(Reiziger.class, id);
		
		return reiziger;
	}
	

	public Reiziger save(Reiziger reiziger) {
		
		emr.getTransaction().begin();
        emr.persist(reiziger);
        emr.getTransaction().commit();
        
        return reiziger;
	}
	
	


	public Reiziger update(Reiziger reiziger) {
		
		emr.getTransaction().begin();
        emr.merge(reiziger);
        emr.getTransaction().commit();
        
        return reiziger;
	
	}

	public Reiziger delete(Reiziger reiziger) {
		
		emr.getTransaction().begin();
		emr.remove(reiziger);
		emr.getTransaction().commit();
		
        return reiziger;
	}

	public void closeConnection() {
		emr.close();
		
	}


}
