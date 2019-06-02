package P3;

import java.sql.Date;

public class ProductOvchipkaart {
	
	private int OVchipkaartProductID;
	private OVChipkaart ov;
	private Product product;
	private String status;
	private Date update;
	
	
	public ProductOvchipkaart(int oVchipkaartProductID, OVChipkaart ov, Product product, String status, Date update) {

		OVchipkaartProductID = oVchipkaartProductID;
		this.ov = ov;
		this.product = product;
		this.status = status;
		this.update = update;
	}


	public int getOVchipkaartProductID() {
		return OVchipkaartProductID;
	}


	public OVChipkaart getOv() {
		return ov;
	}


	public Product getProduct() {
		return product;
	}


	public String getStatus() {
		return status;
	}


	public Date getUpdate() {
		return update;
	}


	public void setOVchipkaartProductID(int oVchipkaartProductID) {
		OVchipkaartProductID = oVchipkaartProductID;
	}


	public void setOv(OVChipkaart ov) {
		this.ov = ov;
	}


	public void setProduct(Product product) {
		this.product = product;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public void setUpdate(Date update) {
		this.update = update;
	}


	public String toString() {
		return "ProductOvchipkaart [OVchipkaartProductID=" + OVchipkaartProductID + ", ov=" + ov + ", product="
				+ product + ", status=" + status + ", update=" + update + "]";
	}
	
	
	
	
	
	
	
	

}
