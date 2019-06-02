package P3;

import java.util.ArrayList;
import java.util.List;

public class Product {
	
	private int productNummer;
	private String productNaam;
	private String beschrijving;
	private double prijs;
	private List<Integer> ovchipkaarten = new ArrayList<>();
	
	public Product(int productNummer, String productNaam, String beschrijving, double prijs) {
		
		this.productNummer = productNummer;
		this.productNaam = productNaam;
		this.beschrijving = beschrijving;
		this.prijs = prijs;
		
	}

	public int getProductNummer() {
		return productNummer;
	}

	public void setProductNummer(int productNummer) {
		this.productNummer = productNummer;
	}

	public String getProductNaam() {
		return productNaam;
	}

	public void setProductNaam(String productNaam) {
		this.productNaam = productNaam;
	}

	public String getBeschrijving() {
		return beschrijving;
	}

	public void setBeschrijving(String beschrijving) {
		this.beschrijving = beschrijving;
	}

	public double getPrijs() {
		return prijs;
	}

	public void setPrijs(double prijs) {
		this.prijs = prijs;
	}
	
	public List<Integer> getOVChipkaarten(){
		
		return ovchipkaarten;
		
	}
	
	public void setOVChipkaarten(List<Integer> ovchipkaarten) {
		
		this.ovchipkaarten = ovchipkaarten;
		
	}

	@Override
	public String toString() {
		return "Product [productNummer=" + productNummer + ", productNaam=" + productNaam + ", beschrijving="
				+ beschrijving + ", prijs=" + prijs + "]";
	}
	
}

