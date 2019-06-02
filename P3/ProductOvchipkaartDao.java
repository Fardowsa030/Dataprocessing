package P3;

import java.sql.SQLException;
import java.util.List;

public interface ProductOvchipkaartDao {
	public List<ProductOvchipkaart> findAll() throws SQLException;
	public boolean save(ProductOvchipkaart ovProduct) throws SQLException;
	public boolean delete(ProductOvchipkaart ovProduct)throws SQLException;
	public boolean update(ProductOvchipkaart ovProduct)throws SQLException;
	public boolean delete(List<ProductOvchipkaart> product_ov) throws SQLException; // helpt product te verwijderen
	public List<ProductOvchipkaart> findByProduct_OV(int p_ov) throws SQLException;  // helpt product te verwijderen
	
	

}
