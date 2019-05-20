package P3;

import java.sql.Connection;
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


}
