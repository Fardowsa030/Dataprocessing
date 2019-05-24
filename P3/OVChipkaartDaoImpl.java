package P3;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OVChipkaartDaoImpl extends OracleBaseDao implements OVChipkaartDao {
	
	public List<Integer> getAlleKaartnummers() throws SQLException {
		
		Connection conn = super.getConnection();
		
		String getAlleKaartnummers = "select distinct kaartnummer from ov_chipkaart";
		
		PreparedStatement pstmt1 = conn.prepareStatement(getAlleKaartnummers);
		
		ResultSet rs = pstmt1.executeQuery();
		
		int kaartnummer;
		
		List<Integer> kaartnummers = new ArrayList<>();
		
		while (rs.next()) {
			
			kaartnummer = rs.getInt("kaartnummer");
			
			kaartnummers.add(kaartnummer);
			
		}
		
		return kaartnummers;
		


}
	
public OVChipkaart getKaart(int kaartnummer) throws SQLException {
		
		Connection conn = super.getConnection();
		
		String getOVChipkaartOpKaartnummer = "select kaartnummer, geldigtot, klasse, saldo, reizigerid from ov_chipkaart where kaartnummer = ?";
		
		PreparedStatement pstmt1 = conn.prepareStatement(getOVChipkaartOpKaartnummer);
		pstmt1.setInt(1, kaartnummer);
		
		ResultSet rs = pstmt1.executeQuery();
		
		int kn;
		Date geldigtot;
		int klasse;
		double saldo;
		int reizigerid;
		
		while (rs.next()) {
			
			kn = rs.getInt("kaartnummer");
			geldigtot = rs.getDate("geldigtot");
			klasse = rs.getInt("klasse");
			saldo = rs.getDouble("saldo");
			reizigerid = rs.getInt("reizigerid");
			
			OVChipkaart o = new OVChipkaart(kn, geldigtot, klasse, saldo, reizigerid);
			
			ProductDaoImpl pDaoImpl = new ProductDaoImpl();
			
			o.setProducten(pDaoImpl.getProductenByKaartnummer(kn));
			
			return o;
			
		}
		
		return null;
		
	}

public List<Integer> getOVChipkaartNummersByProduct(int productnummer) throws SQLException {
	
	Connection conn = super.getConnection();
	
	String getOVChipkaarten = "select kaartnummer from OV_CHIPKAART_PRODUCT where productnummer = ?";
	
	PreparedStatement pstmt1 = conn.prepareStatement(getOVChipkaarten);
	pstmt1.setInt(1, productnummer);
	
	ResultSet rs = pstmt1.executeQuery();
	
	int kaartnummer;
	
	List<Integer> kaartnummers = new ArrayList<>();
	
	while (rs.next()) {
		
		kaartnummer = rs.getInt("kaartnummer");
		
		kaartnummers.add(kaartnummer);
		
	}
	
	return kaartnummers;
	
}

}


	
	
