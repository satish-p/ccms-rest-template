package app.model.profile;

import java.util.Date;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown=true)
public class CpsSubscription extends CpsCommon {
	private String id;
	private Date effectiveDate;
	private Map<String,String> attributes;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Map<String, String> getAttributes() {
		return attributes;
	}
	public void setAttributes(Map<String, String> attributes) {
		this.attributes = attributes;
	}
	public Date getEffectiveDate() {
		return createDate(effectiveDate);
	}
	public void setEffectiveDate(Date effectiveDate) {
		this.effectiveDate = createDate(effectiveDate);
	}
}
