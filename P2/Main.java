package P2;

import java.sql.Date;
import java.sql.SQLException;

public class Main {

	public static void main(String[] args) throws SQLException {
		
			// ovchipkaart object aangemaakt
			ovChipkaartDao ovDao = new OvChipkaartDaoImpl();
			// CRUD - READ
			for (OvChipkaart ov : ovDao.findAll()) {
				System.out.println(ov.toString());
				System.out.println("");
			}
			
			System.out.println("");
			
			// reiziger object aangemaakt
			Reiziger reiziger = new Reiziger(1, "F", "Ali", "Harry", Date.valueOf("1996-02-03"));
			
			// vind ovchipkaart door middel van input reiziger
			for (OvChipkaart ov : ovDao.findByReiziger(reiziger)) {
				System.out.println(ov.toString());
				System.out.println("");

			}
			
			// ov object
			OvChipkaart ovChip = new OvChipkaart(12346, Date.valueOf("2018-10-10"), 3, 150.0, reiziger);

			//CRUD - SAVE
			//ovDao.save(ovChip);
			//CRUD - UPDATE
			//ovChip.setKlasse(1);
			//ovDao.update(ovChip);
			//CRUD - DELETE
			ovDao.delete(ovChip);
		}
	
}


	


	
	


