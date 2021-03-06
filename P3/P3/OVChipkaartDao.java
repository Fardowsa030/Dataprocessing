package P3;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import P3.OVChipkaart;

public interface OVChipkaartDao {
	
	public List<Integer> getAlleKaartnummers() throws SQLException;
	public OVChipkaart getKaart(int kaartnummer) throws SQLException;
	public List<Integer> getOVChipkaartNummersByProduct(int productnummer) throws SQLException;
	public List<OVChipkaart> findAll() throws SQLException;
	public List<OVChipkaart> findByReiziger(int reizigerid) throws SQLException;
	public boolean save(OVChipkaart ovchipkaart) throws SQLException;
	public boolean saveKoppel(OVChipkaart ovchipkaart) throws SQLException;
	public boolean update(OVChipkaart ovchipkaart) throws SQLException;
	public boolean updateKoppel(OVChipkaart ovchipkaart) throws SQLException;
	public void closeConnection(Connection conn) throws SQLException;
	public boolean delete(OVChipkaart ov)throws SQLException;
	public boolean deleteKoppel(OVChipkaart ov)throws SQLException;
	public int createUniqueID();
	



}
