package app.service;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import app.service.DataNotFoundException;

public class DataNotFoundExceptionTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testDataNotFoundExceptionString() {
		DataNotFoundException dataNotFoundException = new DataNotFoundException("not found");
		assertNotNull(dataNotFoundException);
	}

}
