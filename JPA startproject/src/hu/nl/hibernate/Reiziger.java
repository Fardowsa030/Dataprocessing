package hu.nl.hibernate;

import java.sql.Date;


public class Reiziger {
	
	private int reizigerID;
	private String voorletters;
	private String tussenvoegsels;
	private String achternaam;
	private Date gbdatum;

	
	public Reiziger(int reizigerID, String voorletters, String tussenvoegsels, String achternaam, Date gbdatum) {
		
		this.reizigerID = reizigerID;
		this.voorletters = voorletters;
		this.tussenvoegsels = tussenvoegsels;
		this.achternaam = achternaam;
		this.gbdatum = gbdatum;
		
	}
	
	public Reiziger() {}
	
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


	public String toString() {
		return "Reiziger [reizigerID=" + reizigerID + ", voorletters=" + voorletters + ", tussenvoegsels="
				+ tussenvoegsels + ", achternaam=" + achternaam + ", gbdatum=" + gbdatum + "]";
	}
	


}
