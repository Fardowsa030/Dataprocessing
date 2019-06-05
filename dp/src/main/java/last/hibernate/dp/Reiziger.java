package last.hibernate.dp;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.*;


@Entity(name = "Reiziger")
@Table(name = "REIZIGER")

public class Reiziger {
	@Id
        @GeneratedValue
	private int reizigerid;
	
	private String voorletters;
	private String tussenvoegsel;
	private String achternaam;
	private Date geboortedatum;
	
	@OneToMany(
        cascade = CascadeType.ALL,
        orphanRemoval = true
    )
	List<OVChipkaart> ov = new ArrayList<OVChipkaart>();
	


	public Reiziger() {
		
	}
	
	public Reiziger(int reizigerid, String voorletters, String tussenvoegsel, String achternaam, Date geboortedatum,
			List<OVChipkaart> ov) {
		this.reizigerid = reizigerid;
		this.voorletters = voorletters;
		this.tussenvoegsel = tussenvoegsel;
		this.achternaam = achternaam;
		this.geboortedatum = geboortedatum;
		this.ov = ov;
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
	public List<OVChipkaart> getOv() {
		return ov;
	}

	public void setOv(List<OVChipkaart> ov) {
		this.ov = ov;
	}

	@Override
	public String toString() {
		return "Reiziger [reizigerid=" + reizigerid + ", voorletters=" + voorletters + ", tussenvoegsel="
				+ tussenvoegsel + ", achternaam=" + achternaam + ", geboortedatum=" + geboortedatum + ", ov=" + ov
				+ "]";
	}
	
	
	
	
}


