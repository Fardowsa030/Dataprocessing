package P3;

import java.sql.Date;
import java.sql.SQLException;

public class OVChiokaartProductCRUD {

	public static void main(String[] args) throws SQLException {
		
		ProductOvchipkaartDao pod = new ProductOvDaoImpl();
		
	
		// findAll methode 
		  
		   for(ProductOvchipkaart product_ov: pod.findAll()) {
			   System.out.println(product_ov.toString());
			   System.out.println("----------------");
		   }
		
		
		// maak reiziger object aan
		Reiziger reiziger = new Reiziger(2,"F","Ali","Hussein",Date.valueOf("1996-03-02"));
		
		// maak ovchipkaart object aan
		
		OVChipkaart ov = new OVChipkaart(35283,Date.valueOf("2018-05-31"),2,25,reiziger);
		
		// maak product object aan
		
		Product product = new Product(1,"dagkaart 2e klas","onzin",50);
		
		// maak ovchipkaart-product object
		
		ProductOvchipkaart po = new ProductOvchipkaart(9,ov,product,"actief",Date.valueOf("1990-02-03"));
		
		// persist productOvchipkaart object naar database
		
		if(pod.save(po)) {
			System.out.println("ovchipkaart product is gepersisteert");
		}
		else {
			System.out.println("ovchipkaart product is NIET gepersisteert");
		}
		
		
		// update productOvchipkaart object
		  
		// maak nieuwe product object aan voor update
		Product product1 = new Product(2,"dagkaart fiets",".....",70);
		
		 System.out.println("voor verandering: "+ po.getProduct().toString());
		 po.setProduct(product1);
         pod.update(po);
         System.out.println("na verandering: "+ po.getProduct().toString());
		
		
		
		if(pod.delete(po)) {
			System.out.println("ovchipkaart product is verwijderd");
		}
		else {
			System.out.println("ovchipkaart product is NIET verwijdered");
		}
	
		
		// maak product object aan 
		Product product6 = new Product(6,"Studentenreisproduct","gratis",0);
		ProductDao pdao = new ProductDaoImpl();
		
		// findall products
		
		 for(Product productFind: pdao.findAll()) {
			   System.out.println(productFind.toString());
			   System.out.println("----------------");
		   }
		
		
		// save product
		 
		if(pdao.save(product6)) {
			System.out.println("product " + product6.getProductNummer() + " is opgeslagen" );
		}
		else {
			System.out.println("error!");
		}
		
		
		// update
		
		 System.out.println("voor verandering: "+ product6.getProductNaam());
		 product6.setProductNaam("testttt");;
         pdao.update(product6);
         System.out.println("na verandering: "+ product6.getProductNaam());
		
		
		
		
		// delete product
		
		if(pdao.delete(product6)) {
			System.out.println("product " + product6.getProductNummer() + " is verwijderd uit de koppel en product tabel" );
		}
		else {
			System.out.println("error!");
		}
		
		
		

	}

}
