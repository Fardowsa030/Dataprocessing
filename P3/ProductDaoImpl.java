package P3;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDaoImpl extends OracleBaseDao implements ProductDao {
	
public List<Product> getProductenByKaartnummer(int kaartnummer) throws SQLException {
		
		Connection conn = super.getConnection();
		
		String getProductenByKaartnummer = "select product.productnummer, productnaam, beschrijving, prijs from ov_chipkaart, ov_chipkaart_product, product where ov_chipkaart.kaartnummer = ov_chipkaart_product.kaartnummer and ov_chipkaart_product.productnummer = product.productnummer and ov_chipkaart.kaartnummer = ?";
		
		PreparedStatement pstmt1 = conn.prepareStatement(getProductenByKaartnummer);
		pstmt1.setInt(1, kaartnummer);
		
		ResultSet rs = pstmt1.executeQuery();
		
		int productnummer;
		String productnaam;
		String beschrijving;
		double prijs;
		
		List<Product> producten = new ArrayList<>();
		
		while (rs.next()) {
			
			productnummer = rs.getInt("productnummer");
			productnaam = rs.getString("productnaam");
			beschrijving = rs.getString("beschrijving");
			prijs = rs.getDouble("prijs");
			
			Product p = new Product(productnummer, productnaam, beschrijving, prijs);
			
			OVChipkaartDaoImpl ovDaoImpl = new OVChipkaartDaoImpl();
			
			p.setOVChipkaarten(ovDaoImpl.getOVChipkaartNummersByProduct(productnummer));
			
			producten.add(p);
			
		}
		
		return producten;
		
	}

public Product getProduct(int productnummer) throws SQLException {
	
	Connection conn = super.getConnection();
	
	String getProduct = "select productnummer,productnaam, beschrijving, prijs from product where productnummer = ?";
	
	PreparedStatement pstmt1 = conn.prepareStatement(getProduct);
	pstmt1.setInt(1, productnummer);
	
	ResultSet rs = pstmt1.executeQuery();
	
	int productnummerID;
	String productnaam;
	String beschrijving;
	double prijs;
	
	while (rs.next()) {
		
		
		
		productnummerID = rs.getInt("productnummer");
		productnaam = rs.getString("productnaam");
		beschrijving = rs.getString("beschrijving");
		prijs = rs.getDouble("prijs");
		
		Product product = new Product(productnummerID,productnaam,beschrijving,prijs);
		
		return product;	
		
	}
	return null;
	
	
	
}


public List<Product> findAll() throws SQLException {
		
	String getProduct = "select * from product";
	
	PreparedStatement pstmt1 = conn.prepareStatement(getProduct);
	
	ResultSet rs = pstmt1.executeQuery();
	
	int productnummer;
	String productnaam;
	String beschrijving;
	double prijs;

	List<Product> producten = new ArrayList<>();
	
	while (rs.next()) { 
	
		
		productnummer = rs.getInt("productnummer");
		productnaam = rs.getString("productnaam");
		beschrijving = rs.getString("beschrijving");
		prijs = rs.getInt("prijs");		
		Product product = new Product(productnummer,productnaam,beschrijving,prijs);
		producten.add(product);

	}
	
	return producten;
}

 
public boolean save(Product product) throws SQLException {
	String saveProduct = "insert into product values (?, ?, ?, ?)";
	PreparedStatement pstmt1 = conn.prepareStatement(saveProduct);
	pstmt1.setInt(1, product.getProductNummer());
	pstmt1.setString(2, product.getProductNaam());
	pstmt1.setString(3, product.getBeschrijving());
	pstmt1.setDouble(4, product.getPrijs());
	int count = pstmt1.executeUpdate();
    
	if (count > 0) {
		
		return true;
		
	}

	
	return false;
}


public boolean saveKoppel(Product product,OVChipkaart ov) throws SQLException {
	String saveProduct = "insert into ov_chipkaart_product values (?, ?, ?, ?,?)";
	PreparedStatement pstmt1 = conn.prepareStatement(saveProduct);
	pstmt1.setInt(1, 17);
	pstmt1.setInt(2, ov.getKaartNummer());
	pstmt1.setInt(3, product.getProductNummer());
	pstmt1.setString(4, "actief");
	pstmt1.setString(5, "03-02-1996");
	int count = pstmt1.executeUpdate();
    
	if (count > 0) {
		
		return true;
		
	}

	
	return false;
}


public boolean delete(Product product)throws SQLException {

    boolean success = false;
   
    PreparedStatement stmt = conn.prepareStatement("delete from product where productnummer = ?");
    stmt.setInt(1, product.getProductNummer());

        if(stmt.executeUpdate() > 0) {
            success = true;
           
        }
    

        return success;

}





public boolean deleteKoppel(Product product)throws SQLException {

    boolean success = false;
   
    PreparedStatement stmt = conn.prepareStatement("delete from ov_chipkaart_product where productnummer = ?");
    stmt.setInt(1, product.getProductNummer());
    

        if(stmt.executeUpdate() > 0) {
            success = true;
           
        }
    

        return success;

}


public boolean update(Product product) throws SQLException {	
	String updateOVChipkaart = "update product set productnaam = ?, beschrijving = ?, prijs = ? where productnummer = ?";
	
	PreparedStatement ps = conn.prepareStatement(updateOVChipkaart);
	
	ps.setString(1, product.getProductNaam());
	ps.setString(2, product.getBeschrijving());
	ps.setDouble(3, product.getPrijs());
	ps.setInt(4, product.getProductNummer());
	
    int count = ps.executeUpdate();
    
	if (count > 0) {
		
		return true;
		
	}

	
	return false;
}






}
