package app.stats;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.junit.Before;
import org.junit.Test;

public class ProfilerTest {

	private Profiler profiler;
	
	@Before
	public void setup() {
		profiler = new Profiler();
	}
	
	@Test
	public void testProfiler() {
		Profiler profiler = new Profiler();
		assertNotNull(profiler);
	}

	@Test
	public void testInWebLayer() {
		profiler.inWebLayer();
	}

	@Test
	public void testInServiceLayer() {
		profiler.inServiceLayer();
	}

	@Test
	public void testInDaoLayer() {
		profiler.inDaoLayer();
	}

	@Test
	public void testDoBasicProfiling() throws Throwable {
		// Set Expectations
		ProceedingJoinPoint pjp = mock(ProceedingJoinPoint.class);
		Signature signature = mock(Signature.class);
		when(signature.toShortString()).thenReturn("SomeClass.doSomething()");
		when(pjp.getSignature()).thenReturn(signature);
		when(pjp.proceed()).thenReturn("response");
		
		profiler.doBasicProfiling(pjp);
		
		// Verify
		verify(signature).toShortString();
		verify(pjp).getSignature();
		verify(pjp).proceed();
	}


	@Test
	public void testReset() {
		profiler.reset();
	}

	@Test
	public void testGetDelimitedHogStats() throws Exception {
		assertNotNull(profiler.getDelimitedHogStats());
	}

	@Test
	public void testGetHtmlHogStats() {
		profiler.getHtmlHogStats();
	}

	@Test
	public void testToString() throws Exception {
		assertNotNull(profiler.toString());
	}

	@Test
	public void testClearStats() {
		profiler.clearStats();
	}

}
