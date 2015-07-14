package app.service;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.NOT_FOUND, reason="Data not found")
public class DataNotFoundException extends RuntimeException {

	private static final long serialVersionUID = -3949585886968568733L;

	public DataNotFoundException(String message) {
		super(message);
	}
}
