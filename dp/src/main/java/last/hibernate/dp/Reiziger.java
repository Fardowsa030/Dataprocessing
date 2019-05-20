package last.hibernate.dp;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.*;


@Entity
@Table(name = "reiziger")
public class Reiziger {
	
	@Id
   // @GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "reiziger_Sequence")
   // @SequenceGenerator(name = "reiziger_Sequence", sequenceName = "REIZIGER_SEQ")
	private int reizigerid;
	
	private String voorletters;
	private String tussenvoegsel;
	private String achternaam;
	private Date geboortedatum;
	


	public Reiziger() {
		
	}
	
	public Reiziger(int reizigerid, String voorletters, String tussenvoegsel, String achternaam, Date geboortedatum) {
		this.reizigerid = reizigerid;
		this.voorletters = voorletters;
		this.tussenvoegsel = tussenvoegsel;
		this.achternaam = achternaam;
		this.geboortedatum = geboortedatum;
	}
	
	public String getVoorletters() {
		return voorletters;
	}
	public int getReizigerid() {
		return reizigerid;
	}

	public void setReizigerid(int reizigerid) {
		this.reizigerid = reizigerid;
	}

	public void setVoorletters(String voorletters) {
		this.voorletters = voorletters;
	}
	public String getTussenvoegsel() {
		return tussenvoegsel;
	}
	public void setTussenvoegsel(String tussenvoegsel) {
		this.tussenvoegsel = tussenvoegsel;
	}
	public String getAchternaam() {
		return achternaam;
	}
	public void setAchternaam(String achternaam) {
		this.achternaam = achternaam;
	}
	public Date getGeboortedatum() {
		return geboortedatum;
	}
	public void setGeboortedatum(Date geboortedatum) {
		this.geboortedatum = geboortedatum;
	}
	
	public String toString() {
		return "Reiziger{" +
                "reizgierid=" + reizigerid +
                ", voorletters=" + voorletters +
                ", tussenvoegsel=" + tussenvoegsel +
                ", achternaam=" + achternaam +
                ", geboortedatum='" + geboortedatum + '\'' +
                '}';
	}
	
	
}


