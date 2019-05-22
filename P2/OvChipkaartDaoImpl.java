package P2;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OvChipkaartDaoImpl extends OracleBaseDao implements ovChipkaartDao {
	
public List<OvChipkaart> findAll() throws SQLException {
		
		Connection conn = super.getConnection();
		
		String getOVChipkaarten = "select * from ov_chipkaart";
		
		PreparedStatement pstmt1 = conn.prepareStatement(getOVChipkaarten);
		
		ResultSet rs = pstmt1.executeQuery();
		
		int kaartnummer;
		Date geldigtot;
		int klasse;
		double saldo;
	

		
		List<OvChipkaart> OVChipkaarten = new ArrayList<>();
		
		while(rs.next()) {
			ReizigerDao reiziger = new ReizigerDaoImpl();
			Reiziger r1 = reiziger.getById(rs.getInt("reizigerid"));
			
			
			kaartnummer = rs.getInt("kaartnummer");
			geldigtot = rs.getDate("geldigtot");
			klasse = rs.getInt("klasse");
			saldo = rs.getDouble("saldo");
		
		
			
			
			OvChipkaart o = new OvChipkaart(kaartnummer, geldigtot, klasse, saldo, r1);
			OVChipkaarten.add(o);
			
		}
		
		return OVChipkaarten;
		
	}

public List<OvChipkaart> findByReiziger(int reizigerid) throws SQLException {
	
	Connection conn = super.getConnection();
	
	String getOVChipkaartenByReiziger = "select kaartnummer, geldigtot, klasse, saldo, reizigerid from ov_chipkaart where REIZIGERID  = ?";
	
	PreparedStatement pstmt1 = conn.prepareStatement(getOVChipkaartenByReiziger);
	
	pstmt1.setInt(1, reizigerid);
	
	ResultSet rs = pstmt1.executeQuery();
	
	int kaartnummer;
	Date geldigtot;
	int klasse;
	double saldo;
	int reiziger_id;
	
	List<OvChipkaart> OVChipkaarten = new ArrayList<>();
	
	while(rs.next()) {
		ReizigerDao reiziger = new ReizigerDaoImpl();
		Reiziger r1 = reiziger.getById(rs.getInt("reizigerid"));
		
		kaartnummer = rs.getInt("kaartnummer");
		geldigtot = rs.getDate("geldigtot");
		klasse = rs.getInt("klasse");
		saldo = rs.getDouble("saldo");
		reiziger_id = rs.getInt("REIZIGERID");
		
		OvChipkaart o = new OvChipkaart(kaartnummer, geldigtot, klasse, saldo,reiziger_id,r1);
		OVChipkaarten.add(o);
		
	}
	
	return OVChipkaarten;
	
}

public OvChipkaart save(OvChipkaart ovchipkaart) throws SQLException { 
	
	Connection conn = super.getConnection();
	
	String saveOVChipkaart = "insert into ov_chipkaart values (?, ?, ?, ?, ?)";
	
	PreparedStatement pstmt1 = conn.prepareStatement(saveOVChipkaart);
	
	pstmt1.setInt(1, ovchipkaart.getKaartNummer());
	pstmt1.setDate(2, ovchipkaart.getGeldigTot());
	pstmt1.setInt(3, ovchipkaart.getKlasse());
	pstmt1.setDouble(4, ovchipkaart.getSaldo());
	pstmt1.setInt(5, ovchipkaart.getReiziger().getReizigerID());
	
	int count = pstmt1.executeUpdate();
	
	if (count > 0) {
		
		return ovchipkaart;
		
	}
	
	return null;
	
}

public OvChipkaart update(OvChipkaart ovchipkaart) throws SQLException { 
	
	Connection conn = super.getConnection();
	
	String updateOVChipkaart = "update ov_chipkaart set geldigtot = ?, klasse = ?, saldo = ? where kaartnummer = ?";
	
	PreparedStatement pstmt1 = conn.prepareStatement(updateOVChipkaart);
	
	pstmt1.setDate(1, ovchipkaart.getGeldigTot());
	pstmt1.setInt(2, ovchipkaart.getKlasse());
	pstmt1.setDouble(3, ovchipkaart.getSaldo());
	pstmt1.setInt(4, ovchipkaart.getKaartNummer());
	
	if (pstmt1.executeUpdate() > 0) {
		
		return ovchipkaart;	
	}
	
	return null;
}

public boolean delete(OvChipkaart ovchipkaart) throws SQLException {
	
	Connection conn = super.getConnection();
	
	String deleteOVChipkaart = "delete from ov_chipkaart where kaartnummer = ? and geldigtot = ? and klasse = ? and saldo = ? and reizigerid = ?";
	
	PreparedStatement pstmt1 = conn.prepareStatement(deleteOVChipkaart);
	
	pstmt1.setInt(1, ovchipkaart.getKaartNummer());
	pstmt1.setDate(2, ovchipkaart.getGeldigTot());
	pstmt1.setInt(3, ovchipkaart.getKlasse());
	pstmt1.setDouble(4, ovchipkaart.getSaldo());
	pstmt1.setInt(5, ovchipkaart.getReiziger().getReizigerID());
	
	if (pstmt1.executeUpdate() > 0) {
			
		return true;
	}
	
	return false;
}

public void closeConnection(Connection conn) throws SQLException {
	
	conn.close();
}

}

