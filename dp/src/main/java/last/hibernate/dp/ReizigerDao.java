package last.hibernate.dp;

import java.util.List;

public interface ReizigerDao {
	
	public List<Reiziger> getReizigers();
	public Reiziger save(Reiziger reiziger);
	public Reiziger update(Reiziger reiziger);
	public Reiziger delete(Reiziger reiziger);
	public void closeConnection();


}
