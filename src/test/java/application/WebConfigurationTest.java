package application;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import application.WebConfiguration;

public class WebConfigurationTest {

	private WebConfiguration webConfiguration = new WebConfiguration();
	
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testMsStats() throws Exception {
		assertNotNull(webConfiguration.msStats());
	}

}
