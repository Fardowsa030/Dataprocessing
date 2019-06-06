package P3;

import java.sql.SQLException;

public class Main {

	public static void main(String[] args) throws SQLException {
		
       OVChipkaartDao ovDao = new OVChipkaartDaoImpl();
	
		OVChipkaart ov = ovDao.getKaart(35283);
		
		for (Product p : ov.getProducten()) {
			
			System.out.println("Productnaam: " + p.getProductNaam());
			
			for (Integer kaart : p.getOVChipkaarten()) {
				
				System.out.println("Kaartnummer: " + kaart);
				
			}
			
			System.out.println();
		}
		
		System.out.println();
		System.out.println();
		
		
		ProductDao pDao = new ProductDaoImpl();
		Product p = pDao.getProduct(1);
		
		for (Integer k : ovDao.getAlleKaartnummers()) {
			
			System.out.println("Kaartnummer: " + k);
			
			for (Product product : pDao.getProductenByKaartnummer(k)) {
				
				System.out.println("Productnaam: " + product.getProductNaam());
				
			}
			
			System.out.println();
			
		}
		
		/*
		if(pDao.saveKoppel(p, ov)) {
			System.out.println("true");
		}
		*/
		
		/*
		
		if(pDao.delete(p)) {
			System.out.println("true");
		}
		*/
		
		p.setProductNummer(3);
		
		if(pDao.update(p)) {
			System.out.println("true");
		
		}
		
		
		


	}

}
