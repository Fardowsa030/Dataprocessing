package P3;

import java.sql.SQLException;
import java.util.List;

public interface ProductDao {
	
	public List<Product> getProductenByKaartnummer(int kaartnummer) throws SQLException;


}
