package P2;

import java.sql.Date;
import java.sql.SQLException;

public class mainReiziger {

	public static void main(String[] args) throws SQLException {
		
		ReizigerDao rDao = new ReizigerDaoImpl();
		
        Reiziger reiziger = new Reiziger(5, "F", "", "Memari", Date.valueOf("2002-12-03"));

        // CRUD - READ
        for (Reiziger r : rDao.findAll()) {
			System.out.print(r.toString()); 		
        }
	
        // find reiziger door datum
        for (Reiziger r : rDao.findByGBdatum("02-03-96")) {
	         System.out.print(r.toString());
	         System.out.println("");
	         
        }
        
        // CRUD - SAVE
       // rDao.save(reiziger);
        
        
        // CRUD - UPDATE
        //reiziger.setAchternaam("windsor");
        //rDao.update(reiziger);
        
        // CRUD -DELETE
        rDao.delete(reiziger);
        


}
}

		

	



