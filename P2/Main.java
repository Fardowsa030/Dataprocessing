package P2;

import java.sql.Date;
import java.sql.SQLException;

public class Main {

	public static void main(String[] args) throws SQLException {
		
		
		// ovchipkaart findAll (ovchipkaart object ophalen met reiziger)

			ovChipkaartDao ovDao = new OvChipkaartDaoImpl();
			
			// CRUD - READ
						for (OvChipkaart ov : ovDao.findAll()) {
							System.out.println(ov);
							System.out.println("");
						}
		     
						for (OvChipkaart ov : ovDao.findByReiziger(1)) {
							System.out.println(ov.toString());
							System.out.println("");
						
						
			
			
			System.out.println("");
			
		
			/*
			// ov object maken
			OvChipkaart ovChip = new OvChipkaart(12346, Date.valueOf("2018-10-10"), 3, 150.0,5);

			//CRUD - SAVE
			ovDao.save(ovChip);
			//CRUD - UPDATE
			ovChip.setKlasse(1);
			ovDao.update(ovChip);
			//CRUD - DELETE
			ovDao.delete(ovChip);
			*/
			
		}
	
	}
}


	


	
	


