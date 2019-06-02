package P3;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import P2.OvChipkaart;
import P3.OVChipkaart;
import P3.Reiziger;
import P3.ReizigerDao;
import P3.ReizigerDaoImpl;

public class OVChipkaartDaoImpl extends OracleBaseDao implements OVChipkaartDao{
	
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
			
			ReizigerDaoImpl rDaoImpl = new ReizigerDaoImpl();
			
			kn = rs.getInt("kaartnummer");
			geldigtot = rs.getDate("geldigtot");
			klasse = rs.getInt("klasse");
			saldo = rs.getDouble("saldo");
			reizigerid = rs.getInt("reizigerid");
			Reiziger reiziger = rDaoImpl.getById(reizigerid);
			

			OVChipkaart o = new OVChipkaart(kn,geldigtot, klasse, saldo, reiziger);
			
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

public List<OVChipkaart> findAll() throws SQLException {
	
	Connection conn = super.getConnection();
	
	String getOVChipkaarten = "select * from ov_chipkaart";
	
	PreparedStatement pstmt1 = conn.prepareStatement(getOVChipkaarten);
	
	ResultSet rs = pstmt1.executeQuery();
	
	int kaartnummer;
	Date geldigtot;
	int klasse;
	double saldo;


	
	List<OVChipkaart> OVChipkaarten = new ArrayList<>();
	
	while(rs.next()) {
		ReizigerDao reiziger = new ReizigerDaoImpl();
		Reiziger r1 = reiziger.getById(rs.getInt("reizigerid"));
		
		
		kaartnummer = rs.getInt("kaartnummer");
		geldigtot = rs.getDate("geldigtot");
		klasse = rs.getInt("klasse");
		saldo = rs.getDouble("saldo");
	
	
		
		
		OVChipkaart o = new OVChipkaart(kaartnummer, geldigtot, klasse, saldo, r1);
		OVChipkaarten.add(o);
		
	}
	
	return OVChipkaarten;
	
}

public List<OVChipkaart> findByReiziger(int reizigerid) throws SQLException {



		String getOVChipkaartenByReiziger = "select kaartnummer, geldigtot, klasse, saldo, reizigerid from ov_chipkaart where REIZIGERID  = ?";
		
		PreparedStatement pstmt1 = conn.prepareStatement(getOVChipkaartenByReiziger);
		
		pstmt1.setInt(1, reizigerid);
		
		ResultSet rs = pstmt1.executeQuery();
		
		int kaartnummer;
		Date geldigtot;
		int klasse;
		double saldo;
		int reiziger_id;
		
		List<OVChipkaart> OVChipkaarten = new ArrayList<>();
		
		while(rs.next()) {
			ReizigerDao reiziger = new ReizigerDaoImpl();
			Reiziger r1 = reiziger.getById(rs.getInt("reizigerid"));
			
			kaartnummer = rs.getInt("kaartnummer");
			geldigtot = rs.getDate("geldigtot");
			klasse = rs.getInt("klasse");
			saldo = rs.getDouble("saldo");
			reiziger_id = rs.getInt("REIZIGERID");
			
			OVChipkaart o = new OVChipkaart(kaartnummer, geldigtot, klasse, saldo,r1);
			OVChipkaarten.add(o);
			
		}
		
		return OVChipkaarten;

}


public OVChipkaart save(OVChipkaart ovchipkaart) throws SQLException { 

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

public OVChipkaart update(OVChipkaart ovchipkaart) throws SQLException { 

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


public boolean delete(List<OVChipkaart> ovchipkaart) throws SQLException {
		Connection conn = super.getConnection();
		
		for(OVChipkaart ov: ovchipkaart) {
			String deleteOVChipkaart = "delete from ov_chipkaart where kaartnummer = ?";	
			PreparedStatement pstmt1 = conn.prepareStatement(deleteOVChipkaart);
			pstmt1.setInt(1, ov.getKaartNummer());
			if (pstmt1.executeUpdate() <= 0) {
				return false;
			
			}
			
		}

return true;

}


public void closeConnection(Connection conn) throws SQLException {
	conn.close();
	
}






}


	
	
