package P1;

import java.sql.Date;

public class Reiziger {
	
	private String naam;
	private Date gbdatum;
	
	
	public Reiziger(String naam, Date gbdatum) {
		this.naam = naam;
		this.gbdatum = gbdatum;
	}


	public String getNaam() {
		return naam;
	}


	public Date getGbdatum() {
		return gbdatum;
	}


	public void setNaam(String naam) {
		this.naam = naam;
	}


	public void setGbdatum(Date gbdatum) {
		this.gbdatum = gbdatum;
	}


	@Override
	public String toString() {
		return "Reiziger [naam=" + naam + ", gbdatum=" + gbdatum + "]";
	}
	
	
	
	
	
	
	
	

}
