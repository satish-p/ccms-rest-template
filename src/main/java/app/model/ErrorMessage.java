package app.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown=true)
public class ErrorMessage {
	private String code;
	private String description;
	public ErrorMessage(String code, String description) {
		super();
		this.code = code;
		this.description = description;
	}
	public ErrorMessage(int value, String message) {
		this.code = String.valueOf(value);
		this.description = message;
	}
	public String getCode() {
		return code;
	}
	public String getDescription() {
		return description;
	}
	
}
