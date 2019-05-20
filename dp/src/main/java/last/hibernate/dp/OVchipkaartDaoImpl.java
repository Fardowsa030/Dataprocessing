package last.hibernate.dp;

import java.util.List;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

public class OVchipkaartDaoImpl extends OracleBaseDao implements OvDao {
	
	private EntityManager em = super.getConnection();
	
	//CREATE
	public OVChipkaart save(OVChipkaart ov) {
		
		em.getTransaction().begin();
        em.persist(ov);
        em.getTransaction().commit();
        
        return ov;
		
	}
	
	//READ
	@SuppressWarnings("unchecked")
	public List<OVChipkaart> getOVChipkaarten() {
		
		Query query = em.createQuery("FROM " + OVChipkaart.class.getName());
		
		return (List<OVChipkaart>) query.getResultList();
	}
	
	//UPDATE
	public OVChipkaart update(OVChipkaart ov) {
		
		em.getTransaction().begin();
        em.merge(ov);
        em.getTransaction().commit();
        
        return ov;
		
	}
	
	//DELETE
	public OVChipkaart delete(OVChipkaart ov) {
		
		em.getTransaction().begin();
		em.remove(ov);
		em.getTransaction().commit();
		
        return ov;
		
	}
	
	public OVChipkaart find(int id) {
		OVChipkaart ov = null;
		ov = em.find(OVChipkaart.class, id);
		
		return ov;
	}
	
	
	
	public void closeConnection() {
		
		em.close();
		
	}

}

