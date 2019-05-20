package last.hibernate.dp;

import java.sql.Date;

public class Main {

    public static void main(String[] args) {
    	
    	//maak reiziger object aan
    	Reiziger r1 = new Reiziger(10,"F","Ali","Hussein",Date.valueOf("1996-03-02"));
    	//maak ovchipkaart object aan
    	OVChipkaart ov1 = new OVChipkaart(6,Date.valueOf("1990-01-01"),"mijn eerste kaart",r1);
    	System.out.println(ov1.toString());
    	
    	
    	ReizigerDaoImpl rDao = new ReizigerDaoImpl();

    	//save crud reiziger
    	rDao.save(r1);
    	
    	//crud read reiziger
      for (Reiziger r : rDao.getReizigers()) {
    		
    		System.out.println("Reiziger: " + r.toString());
    		
    	}
    	//delete reiziger // eerst tabel ovchipkaart deleten
    	 rDao.delete(r1);
    	
    	
    
        // find reiziger
    	Reiziger rrr = rDao.find(r1.getReizigerid());
    	System.out.println(rrr.toString());
    	 
    	
    	
    	// udate reiziger
    	r1.setAchternaam("Harry");
    	rDao.update(r1);
    	
    	
    // einde persisteren reiziger object	
    	
    	
    	
    	OVchipkaartDaoImpl oDao = new OVchipkaartDaoImpl();
    	
    	//save ovchipkaart met reizigerid
    	 oDao.save(ov1);
    	
    	//krijgt ov chipkaart object met reiziger object
    	
    	OVChipkaart ovtest = oDao.find(ov1.getKaartnr());
    	System.out.println(ovtest);
    	
    	
    	//read ovchipkaarten
    	for (OVChipkaart o : oDao.getOVChipkaarten()) {
    		
    		System.out.println("OVChipkaart: " + o.toString());
    		
    	}

  
    	
    	//update ovchipkaart
    	ov1.setGeldigheid(Date.valueOf("2018-01-02"));
    	oDao.update(ov1);
    	
    	//delete cascading ovchipkaart object en bijbehorende reiziger object
    	oDao.delete(ov1);
    	rDao.delete(r1);
    	
    	rDao.closeConnection();
    	oDao.closeConnection();
    	
    	
    	

        System.out.println("-- einde --");
        
    }
    
}
