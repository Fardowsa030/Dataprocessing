package last.hibernate.dp;

import javax.persistence.*;


import java.sql.Date;

@Entity
@Table(name = "ovchipkaart")
public class OVChipkaart {
    
    @Id
    @GeneratedValue
    private int kaartnr;
    private Date geldigheid;
    private String kaartopdruk;
    
   
    @ManyToOne(targetEntity = Reiziger.class, cascade = CascadeType.ALL)	
    @JoinColumn(name = "REIZIGER_REIZIGERID")
    private Reiziger reiziger;
   
    public OVChipkaart(int kaartnr, Date geldigheid, String kaartopdruk, Reiziger reiziger) {
    	this.kaartnr = kaartnr;
		this.geldigheid = geldigheid;
		this.kaartopdruk = kaartopdruk;
		this.reiziger = reiziger;
	}
    
    public OVChipkaart() {}



	public Reiziger getReiziger() {
		return reiziger;
	}

	public void setReiziger(Reiziger reiziger) {
		this.reiziger = reiziger;
	}

	public int getKaartnr() {
        return kaartnr;
    }

    public void setKaartnr(int kaartnr) {
        this.kaartnr = kaartnr;
    }

    public Date getGeldigheid() {
        return geldigheid;
    }

    public void setGeldigheid(Date geldigheid) {
        this.geldigheid = geldigheid;
    }

    public String getKaartopdruk() {
        return kaartopdruk;
    }

    public void setKaartopdruk(String kaartopdruk) {
        this.kaartopdruk = kaartopdruk;
    }

	@Override
	public String toString() {
		return "OVChipkaart [kaartnr=" + kaartnr + ", geldigheid=" + geldigheid + ", kaartopdruk=" + kaartopdruk
				+ ", reiziger=" + reiziger + "]";
	}

    
    
}
