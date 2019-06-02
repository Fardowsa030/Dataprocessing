package P3;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



public class ProductOvDaoImpl extends OracleBaseDao implements ProductOvchipkaartDao {
	Connection conn = super.getConnection();
	

	public boolean save(ProductOvchipkaart ovProduct) throws SQLException {
		System.out.println(ovProduct.getUpdate());
		System.out.println(ovProduct.getUpdate().getClass().getName());
		String saveOVChipkaartProduct = "insert into ov_chipkaart_product values (?, ?, ?, ?, ?)";
		PreparedStatement pstmt1 = conn.prepareStatement(saveOVChipkaartProduct);
		pstmt1.setInt(1, ovProduct.getOVchipkaartProductID());
		pstmt1.setInt(2, ovProduct.getOv().getKaartNummer());
		pstmt1.setInt(3, ovProduct.getProduct().getProductNummer());
		pstmt1.setString(4, ovProduct.getStatus());
		pstmt1.setDate(5, ovProduct.getUpdate());
		int count = pstmt1.executeUpdate();
        
		if (count > 0) {
			
			return true;
			
		}

		
		return false;
	}
	
	public boolean delete(ProductOvchipkaart ovProduct)throws SQLException {

	    PreparedStatement ps = conn.prepareStatement("DELETE FROM ov_chipkaart_product WHERE ovproductid=?");
	    ps.setInt(1, ovProduct.getOVchipkaartProductID());
	    int count = ps.executeUpdate();
         if (count > 0) {
              return true;	
		}

		   return false;
	}
	
	
	public boolean update(ProductOvchipkaart ovProduct) throws SQLException { 
		
		Connection conn = super.getConnection();
		
		String updateOVChipkaart = "update ov_chipkaart_product set kaartnummer = ?, productnummer = ?, reisproductstatus = ?, lastupdate = ? where ovproductid = ?";
		
		PreparedStatement ps = conn.prepareStatement(updateOVChipkaart);
		
		ps.setInt(1, ovProduct.getOv().getKaartNummer());
		ps.setInt(2, ovProduct.getProduct().getProductNummer());
		ps.setString(3, ovProduct.getStatus());
		ps.setDate(4, ovProduct.getUpdate());
		ps.setInt(5, ovProduct.getOVchipkaartProductID());
        int count = ps.executeUpdate();
        
		if (count > 0) {
			
			return true;
			
		}

		
		return false;
	}
	
	 public List<ProductOvchipkaart> findAll() throws SQLException {
	        List<ProductOvchipkaart> ov_productLijst = new ArrayList<ProductOvchipkaart>();
	        PreparedStatement ps = conn.prepareStatement("select * from ov_chipkaart_product");

	            ResultSet rs = ps.executeQuery();

	            while (rs.next()) {
	            	OVChipkaartDao ovdao = new OVChipkaartDaoImpl();
	            	OVChipkaart ovKaart = ovdao.getKaart(rs.getInt("kaartnummer"));
	            	ProductDao pdao = new ProductDaoImpl();
	            	Product product = pdao.getProduct(rs.getInt("productnummer"));
	            	
	            	int ovproductID = rs.getInt("ovproductid");
	            	String reisproductStatus = rs.getString("reisproductstatus");
	            	Date lastUpdate = rs.getDate("lastupdate");
	            	
	            	ProductOvchipkaart product_ov = new ProductOvchipkaart(ovproductID,ovKaart,product,reisproductStatus,lastUpdate);
	            	
          	
	            	
	                ov_productLijst.add(product_ov);
	                
	            }
	          

	        return ov_productLijst;
	    }
	
	 
	 public boolean delete(List<ProductOvchipkaart> product_ov) throws SQLException {
			Connection conn = super.getConnection();
			
			for(ProductOvchipkaart p_ov: product_ov) {
				String deleteProduct = "delete from ov_chipkaart_product where ovproductid = ?";	
				PreparedStatement pstmt1 = conn.prepareStatement(deleteProduct);
				pstmt1.setInt(1, p_ov.getOVchipkaartProductID());
				if (pstmt1.executeUpdate() <= 0) {
					return false;
				
				}
				
			}

	return true;

	}

	 public List<ProductOvchipkaart> findByProduct_OV(int p_ov) throws SQLException {



			String getProductOV = "select ovproductid, kaartnummer,productnummer,reisproductstatus,lastupdate from ov_chipkaart_product where productnummer  = ?";
			
			PreparedStatement pstmt1 = conn.prepareStatement(getProductOV);
			
			pstmt1.setInt(1, p_ov);
			
			ResultSet rs = pstmt1.executeQuery();
		
			
			List<ProductOvchipkaart> product_ovLijst = new ArrayList<>();
			
			while(rs.next()) {
				OVChipkaartDao ovdao = new OVChipkaartDaoImpl();
            	OVChipkaart ovKaart = ovdao.getKaart(rs.getInt("kaartnummer"));
            	ProductDao pdao = new ProductDaoImpl();
            	Product product = pdao.getProduct(rs.getInt("productnummer"));
            	
            	int ovproductID = rs.getInt("ovproductid");
            	String reisproductStatus = rs.getString("reisproductstatus");
            	Date lastUpdate = rs.getDate("lastupdate");
            	
            	ProductOvchipkaart product_ov = new ProductOvchipkaart(ovproductID,ovKaart,product,reisproductStatus,lastUpdate);
            	
      	
            	
            	product_ovLijst.add(product_ov);
				
			}
			
			return product_ovLijst;

	}
	
	
	
	
	
	

}
