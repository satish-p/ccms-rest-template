package app.model.profile;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown=true)
public class CpsBenefit extends CpsCommon {
	@JsonProperty("effective_date")
	private Date effectiveDate;
	public Date getEffectiveDate() {
		return createDate(effectiveDate);
	}
	public void setEffectiveDate(Date effectiveDate) {
		this.effectiveDate = createDate(effectiveDate);
	}
}
