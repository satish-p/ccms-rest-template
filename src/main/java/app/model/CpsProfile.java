package app.model;

import java.util.Map;

import org.springframework.hateoas.ResourceSupport;

import app.model.profile.NameValuePairs;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown=true)
public class CpsProfile extends ResourceSupport {
	private Map<String, Object> errors;
	private NameValuePairs nameValuePairs;
	private Integer errorCount;

	public Map<String, Object> getErrors() {
		return errors;
	}
	public void setErrors(Map<String, Object> errors) {
		this.errors = errors;
	}
	public NameValuePairs getNameValuePairs() {
		return nameValuePairs;
	}
	public void setNameValuePairs(NameValuePairs nameValuePairs) {
		this.nameValuePairs = nameValuePairs;
	}
	public Integer getErrorCount() {
		return errorCount;
	}
	public void setErrorCount(Integer errorCount) {
		this.errorCount = errorCount;
	}
}
