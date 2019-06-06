package P3;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import P3.Reiziger;

public interface ReizigerDao {
	
	public List<Reiziger> findAll() throws SQLException;
	public List<Reiziger> findByGBdatum(String GBdatum) throws SQLException;
	public Reiziger save(Reiziger reiziger) throws SQLException;
	public Reiziger getById(int reiziger) throws SQLException;
	public Reiziger update(Reiziger reiziger) throws SQLException;
	//public boolean delete(Reiziger reiziger) throws SQLException;
	public void closeConnection(Connection conn) throws SQLException;

}
