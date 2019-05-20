package P3;

import java.sql.SQLException;
import java.util.List;

public interface OVChipkaartDao {
	
	public List<Integer> getAlleKaartnummers() throws SQLException;
	public OVChipkaart getKaart(int kaartnummer) throws SQLException;
	public List<Integer> getOVChipkaartNummersByProduct(int productnummer) throws SQLException;
	



}
