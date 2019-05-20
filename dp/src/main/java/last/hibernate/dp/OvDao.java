package last.hibernate.dp;

import java.util.List;

public interface OvDao {
	
	public List<OVChipkaart> getOVChipkaarten();
	public OVChipkaart save(OVChipkaart ov);
	public OVChipkaart update(OVChipkaart ov);
	public OVChipkaart delete(OVChipkaart ov);
	public void closeConnection();

}
