package P2;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface ovChipkaartDao {
	
	public List<OvChipkaart> findAll() throws SQLException;
	public List<OvChipkaart> findByReiziger(int reizigerid) throws SQLException;
	public OvChipkaart save(OvChipkaart ovchipkaart) throws SQLException;
	public OvChipkaart update(OvChipkaart ovchipkaart) throws SQLException;
	public boolean delete(OvChipkaart ovchipkaart) throws SQLException;
	public void closeConnection(Connection conn) throws SQLException;

}
