package reiziger.annotatie.HibernateAnnotation;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity  
@Table(name= "REIZIGER")   
public class Reiziger {
	
	@Id
	private int reizigerID;
	private String voorletters;
	private String tussenvoegsel;
	private String achternaam;
	private Date geboortedatum;

	
	public Reiziger(int reizigerID, String voorletters, String tussenvoegsel, String achternaam, Date geboortedatum) {
		
		this.reizigerID = reizigerID;
		this.voorletters = voorletters;
		this.tussenvoegsel = tussenvoegsel;
		this.achternaam = achternaam;
		this.geboortedatum = geboortedatum;
		
	}
	
	public Reiziger() {};
	
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
		
		return tussenvoegsel;
		
	}

	public void setTussenvoegsels(String tussenvoegsels) {
		
		this.tussenvoegsel = tussenvoegsels;
		
	}

	public String getAchternaam() {
		
		return achternaam;
		
	}

	public void setAchternaam(String achternaam) {
		
		this.achternaam = achternaam;
		
	}

	public Date getGbdatum() {
		
		return geboortedatum;
		
	}

	public void setGbdatum(Date gbdatum) {
		
		this.geboortedatum = gbdatum;
		
	}

	@Override
	public String toString() {
		return "Reiziger [reizigerID=" + reizigerID + ", voorletters=" + voorletters + ", tussenvoegsel="
				+ tussenvoegsel + ", achternaam=" + achternaam + ", geboortedatum=" + geboortedatum + "]";
	}
	


}


