package P3;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class Main {

	public static void main(String[] args) throws SQLException {
		
       OVChipkaartDao ovDao = new OVChipkaartDaoImpl();
	
		OVChipkaart ov = ovDao.getKaart(46392);
		
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
		
		

		//lijst met kaartnummers maken
				List<Integer> ovchipkaarten = new ArrayList<>();
				ovchipkaarten.add(90537);
				ovchipkaarten.add(35283);
				ovchipkaarten.add(46392);
				
				
		//maak product object aan met nummer 20
			
			
			//System.out.println(p1);
			//System.out.println(p);;
			Product pi = new Product(18,"lalala","wohoe",25);
			pi.setOVChipkaarten(ovchipkaarten);
			Product product = new Product(1,"dagkaart 2e klas","onzin",50);
			
		// save product
		pDao.saveKoppel(pi);
		
		//Product product = pDao.getProduct(1);
		System.out.println(product);
		
		// update product
		product.setBeschrijving("jojokomo");
		product.setOVChipkaarten(ovchipkaarten);
		System.out.println(product);
	
				
		if(pDao.updateKoppel(product)) {
			System.out.println("true");
		}
		else {
			System.out.println("wat is er aan de hand");
		}
		
		
		
		//delete product
		if(pDao.deleteKoppel(product)) {
			System.out.println("true");
		
		
		}
		
		
		////////OV check
		
		// delete
		
		OVChipkaart ov1 = ovDao.getKaart(35283);
		if(ovDao.deleteKoppel(ov1)) {
			System.out.println("true");

		}
		
		// save
		// maak ov object en reiziger object
		Reiziger reiziger = new Reiziger(2,"F","Ali","Hussein",Date.valueOf("1996-03-02"));
		// product objecten
		List<Product> producten = new ArrayList<>();
		Product p1 = pDao.getProduct(2);
		Product p2 = pDao.getProduct(3);
		
		producten.add(p1);
		producten.add(p2);
		System.out.println(producten);
		
		OVChipkaart ov2 = new OVChipkaart(11111,Date.valueOf("2018-05-31"),2,8,reiziger);
		ov2.setProducten(producten);
		
		
		
		if(ovDao.saveKoppel(ov2)) {
			System.out.println("true");
		}
		else {
			System.out.println("error");
		}
		
		// update ov
		
		ov2.setSaldo(100);
		Product p3 = pDao.getProduct(3);
		producten.add(p3);
		ov2.setProducten(producten);
		
		//update
		if(ovDao.updateKoppel(ov2)) {
			System.out.println("true");
		}
		else {
			System.out.println("wat is er aan de hand");
		}
		

		


	}

}
