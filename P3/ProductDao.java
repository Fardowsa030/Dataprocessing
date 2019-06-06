package P3;

import java.sql.SQLException;
import java.util.List;

public interface ProductDao {
	
	public List<Product> getProductenByKaartnummer(int kaartnummer) throws SQLException;
	public Product getProduct(int productnummer) throws SQLException;
	public List<Product> findAll() throws SQLException;
	public boolean save(Product product) throws SQLException;
	public boolean saveKoppel(Product product)throws SQLException;
	public boolean delete(Product product)throws SQLException;
	public boolean update(Product product) throws SQLException;
	public boolean updateKoppel(Product product)throws SQLException;
	public boolean deleteKoppel(Product product)throws SQLException;
	public int createUniqueID();


}
