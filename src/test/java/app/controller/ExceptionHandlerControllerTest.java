package app.controller;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.client.HttpServerErrorException;

import app.controller.ExceptionHandlerController;
import app.model.ErrorMessage;
import app.service.DataNotFoundException;

public class ExceptionHandlerControllerTest {

	private ExceptionHandlerController exceptionHandlerController;
	
	@Before
	public void setUp() throws Exception {
		exceptionHandlerController = new ExceptionHandlerController();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testHandleDataNotFoundException() {
		ErrorMessage errorMessage = exceptionHandlerController.handleDataNotFoundException(new DataNotFoundException("error"));
		assertEquals(HttpStatus.NOT_FOUND.toString(), errorMessage.getCode());
	}

	@Test
	public void testHandleException() throws Exception {
		ErrorMessage errorMessage = exceptionHandlerController.handleException(new Exception("error"));
		assertEquals(HttpStatus.INTERNAL_SERVER_ERROR.toString(), errorMessage.getCode());
	}

	@Test
	public void testHandleHttpServerException() throws Exception {
		ErrorMessage errorMessage = exceptionHandlerController.handleHttpServerException(new HttpServerErrorException(HttpStatus.SERVICE_UNAVAILABLE, "error"));
		assertEquals(HttpStatus.SERVICE_UNAVAILABLE.toString(), errorMessage.getCode());
	}

	@Test
	public void testHandleHttpMessageNotReadableException() throws Exception {
		ErrorMessage errorMessage = exceptionHandlerController.handleHttpMessageNotReadableException(new HttpMessageNotReadableException("error"));
		assertEquals(HttpStatus.SERVICE_UNAVAILABLE.toString(), errorMessage.getCode());
	}

	@Test
	public void testHandleMissingServletRequestParameterException() throws Exception {
		ErrorMessage errorMessage = exceptionHandlerController.handleMissingServletRequestParameterException(new MissingServletRequestParameterException("error", "String"));
		assertEquals(HttpStatus.BAD_REQUEST.toString(), errorMessage.getCode());
	}

}
