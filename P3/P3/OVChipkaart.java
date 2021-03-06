package P3;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class OVChipkaart {
	
	private int kaartNummer;
	private Date geldigTot;
	private int klasse;
	private double saldo;
	private Reiziger reiziger;
	private List<Product> producten = new ArrayList<>();
	
	public OVChipkaart(int kaartNummer, Date geldigTot, int klasse, double saldo, Reiziger reiziger) {
		
		this.kaartNummer = kaartNummer;
		this.geldigTot = geldigTot;
		this.klasse = klasse;
		this.saldo = saldo;
		this.reiziger = reiziger;
		
	}

	public int getKaartNummer() {
		return kaartNummer;
	}

	public void setKaartNummer(int kaartNummer) {
		this.kaartNummer = kaartNummer;
	}

	public Date getGeldigTot() {
		return geldigTot;
	}

	public void setGeldigTot(Date geldigTot) {
		this.geldigTot = geldigTot;
	}

	public int getKlasse() {
		return klasse;
	}

	public void setKlasse(int klasse) {
		this.klasse = klasse;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	
	public List<Product> getProducten(){
		
		return producten;
		
	}
	
	public void setProducten(List<Product> producten) {
		
		this.producten = producten;
		
	}
	
	public Reiziger getReiziger() {
		
		return reiziger;
		
	}
	
	public void setReiziger(Reiziger reiziger) {
		
		this.reiziger = reiziger;
		
	}

	@Override
	public String toString() {
		return "OVChipkaart [kaartNummer=" + kaartNummer + ", geldigTot=" + geldigTot + ", klasse=" + klasse
				+ ", saldo=" + saldo + ", reiziger=" + reiziger + ", producten=" + producten + "]";
	}
	
	
	
}

