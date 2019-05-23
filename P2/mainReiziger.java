package P2;

import java.sql.Date;
import java.sql.SQLException;

public class mainReiziger {

	public static void main(String[] args) throws SQLException {
		

		ReizigerDao rDao = new ReizigerDaoImpl();
		/*
		// reiziger - findAll / haal reizigers op met attribuut ovchipkaart gevuld
		
		for (Reiziger r : rDao.findAll()) {
			System.out.print(r.toString()); 		
        }
		
		// find reiziger door datum
        for (Reiziger r : rDao.findByGBdatum("02-03-96")) {
	         System.out.print(r.toString());
	         System.out.println("");
	         
        }

		/*
		// maak reiziger object aan 
        Reiziger reiziger = new Reiziger(8, "F", "", "Memari", Date.valueOf("1996-03-02"));
        
        // save reiziger object
         rDao.save(reiziger);
         
        // find reiziger door datum
        for (Reiziger r : rDao.findByGBdatum("02-03-96")) {
	         System.out.print(r.toString());
	         System.out.println("");
	         
        }
        
        // CRUD - UPDATE
           reiziger.setAchternaam("windsor");
           rDao.update(reiziger);
           System.out.println("na verandering: "+ reiziger.getAchternaam());
        */
         // CRUD -DELETE
           Reiziger reiziger = new Reiziger(1, "F", "Ali", "Harry", Date.valueOf("1996-03-02"));
           rDao.delete(reiziger);
           
        


}
}

		

	



