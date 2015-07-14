package app.dao.health;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.springframework.test.util.ReflectionTestUtils;

import app.stats.CmiTemplateHealthIndicator;

public class CmiCoreHealthIndicatorTest {

	private CmiTemplateHealthIndicator healthIndicator;
	
	@Before
	public void setUp() throws Exception {
		healthIndicator = new CmiTemplateHealthIndicator();
		ReflectionTestUtils.setField(healthIndicator, "version", "1.0");
	}

	@Test
	public void testHealth() {
		assertNotNull(healthIndicator.health());
	}

}
