package app.controller;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.test.util.ReflectionTestUtils;

import app.controller.StatsController;
import app.stats.Profiler;
import static org.mockito.Mockito.*
;
public class StatsControllerTest {

	private StatsController controller = new StatsController();
	private Profiler profiler;
	
	@Before
	public void setUp() {
		profiler = mock(Profiler.class);
		ReflectionTestUtils.setField(controller, "profiler", profiler);
		
	}
	
	@After
	public void tearDown() {
	}
	
	@Test
	public void testStats() {
		when(profiler.getHtmlHogStats()).thenReturn("<blah></blah>");
		assertNotNull(controller.stats());
		verify(profiler).getHtmlHogStats();
	}

	@Test
	public void testClearStats() {
		when(profiler.getHtmlHogStats()).thenReturn("<blah></blah>");
		assertNotNull(controller.clearStats());
		verify(profiler).getHtmlHogStats();
	}

	@Test
	public void testNsTest() {
		assertNotNull(controller.nstest());
	}

}
