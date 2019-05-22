package P2;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class Reiziger {
	
	private int reizigerID;
	private String voorletters;
	private String tussenvoegsels;
	private String achternaam;
	private Date gbdatum;
	private List<OvChipkaart> ovchipkaarten = new ArrayList<OvChipkaart>();
	

	public Reiziger(int reizigerID, String voorletters, String tussenvoegsels, String achternaam, Date gbdatum) {
		
		this.reizigerID = reizigerID;
		this.voorletters = voorletters;
		this.tussenvoegsels = tussenvoegsels;
		this.achternaam = achternaam;
		this.gbdatum = gbdatum;
		
	}
	
	
	

	public Reiziger(int reizigerID, String voorletters, String tussenvoegsels, String achternaam, Date gbdatum,
			List<OvChipkaart> ovchipkaarten) {
		super();
		this.reizigerID = reizigerID;
		this.voorletters = voorletters;
		this.tussenvoegsels = tussenvoegsels;
		this.achternaam = achternaam;
		this.gbdatum = gbdatum;
		this.ovchipkaarten = ovchipkaarten;
	}




	public int getReizigerID() {
		
		return reizigerID;
		
	}

	public String getVoorletters() {
		
		return voorletters;
		
	}

	public void setVoorletters(String voorletters) {
		
		this.voorletters = voorletters;
		
	}

	public String getTussenvoegsels() {
		
		return tussenvoegsels;
		
	}

	public void setTussenvoegsels(String tussenvoegsels) {
		
		this.tussenvoegsels = tussenvoegsels;
		
	}

	public String getAchternaam() {
		
		return achternaam;
		
	}

	public void setAchternaam(String achternaam) {
		
		this.achternaam = achternaam;
		
	}

	public Date getGbdatum() {
		
		return gbdatum;
		
	}

	public void setGbdatum(Date gbdatum) {
		
		this.gbdatum = gbdatum;
		
	}
	

	public List<OvChipkaart> getOvchipkaarten() {
		return ovchipkaarten;
	}



	public void setOvchipkaarten(List<OvChipkaart> ovchipkaarten) {
		this.ovchipkaarten = ovchipkaarten;
	}




	@Override
	public String toString() {
		return "Reiziger [reizigerID=" + reizigerID + ", voorletters=" + voorletters + ", tussenvoegsels="
				+ tussenvoegsels + ", achternaam=" + achternaam + ", gbdatum=" + gbdatum + ", ovchipkaarten="
				+ ovchipkaarten + "]";
	}




	
	
	


}

