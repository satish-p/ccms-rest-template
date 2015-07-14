package app.model.profile;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown=true)
public class CpsCommon {
	private String svuProdId;
	private String name;
	private String status;
	private String productClass;
	private String productFamily;
	public String getSvuProdId() {
		return svuProdId;
	}
	public void setSvuProdId(String svuProdId) {
		this.svuProdId = svuProdId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getProductClass() {
		return productClass;
	}
	public void setProductClass(String productClass) {
		this.productClass = productClass;
	}
	public String getProductFamily() {
		return productFamily;
	}
	public void setProductFamily(String productFamily) {
		this.productFamily = productFamily;
	}
	
	public static Date createDate(Date date) {
		
		if(date==null) {
			return null;
		}
		
		return new Date(date.getTime());
	}

}
