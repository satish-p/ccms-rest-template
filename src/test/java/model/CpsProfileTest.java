package model;

import static org.junit.Assert.assertNotNull;
import model.CpsProfile;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import dao.CpsDaoStub;

public class CpsProfileTest {

	private static final String SCREEN_NAME = "viktest3";
	
	private CpsProfile cpsProfile;
	
	@Before
	public void setUp() throws Exception {
		cpsProfile = CpsDaoStub.createCpsData(SCREEN_NAME);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetErrors() {
		assertNotNull(cpsProfile.getErrors());
	}

	@Test
	public void testGetNameValuePairs() {
		assertNotNull(cpsProfile.getNameValuePairs());
	}

	@Test
	public void testGetErrorCount() {
		assertNotNull(cpsProfile.getErrorCount());
	}

}
