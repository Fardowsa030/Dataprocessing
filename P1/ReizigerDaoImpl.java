package P1;

import java.sql.Date;

import java.util.ArrayList;
import java.util.List;

public class ReizigerDaoImpl implements ReizigerDao {

	List<Reiziger> reizigers = new ArrayList<>();
	
	
	public List<Reiziger> findAll() {	
			 return reizigers;
		 }


	
	public List<Reiziger> findByGBdatum(String GBdatum){
		  
	
		 List<Reiziger> zelfdeGB = new ArrayList<>();
		
		 for (Reiziger r : reizigers) {
			 
		        if (r.getGbdatum().equals(Date.valueOf(GBdatum))) {
		
		            zelfdeGB.add(r);
		        }
		 }
		 
		 return zelfdeGB;
	 }



	public Reiziger save(Reiziger reiziger) {

		 reizigers.add(reiziger);
		 return reiziger;
	 }


	public Reiziger update(Reiziger reiziger) {
		return reiziger;
	}

	
	public boolean delete(Reiziger reiziger) {

		 boolean same = false;

		 	for (Reiziger r : reizigers) {

		 		if (r.getNaam().equals(reiziger.getNaam()) && r.getGbdatum().equals(reiziger.getGbdatum())) {

		 			same = true;
	                return same;
	            }
	        }

		 	return same;
	    }

	    public void closeConnection() {

	    }


}
