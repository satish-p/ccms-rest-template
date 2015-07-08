package com.aol.cmi.stats;

import static org.junit.Assert.*;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.junit.Before;
import org.junit.Test;
import org.springframework.test.util.ReflectionTestUtils;

import com.aol.util.hog4j.MsStats;

import static org.mockito.Mockito.*;

public class ProfilerTest {

	private Profiler profiler = new Profiler();
	
	private MsStats msStats;
	
	@Before
	public void setup() {
		msStats = mock(MsStats.class);
		profiler.setMsStats(msStats);
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
	public void testDoBasicProfilingMsStatsException() throws Throwable {
		// Set Expectations
		ProceedingJoinPoint pjp = mock(ProceedingJoinPoint.class);
		Signature signature = mock(Signature.class);
		when(signature.toShortString()).thenReturn("SomeClass.doSomething()");
		when(pjp.getSignature()).thenReturn(signature);
		when(pjp.proceed()).thenReturn("response");
		doThrow(new RuntimeException()).when(msStats).update(anyString(), anyLong());

		profiler.doBasicProfiling(pjp);
		
		// Verify
		verify(signature).toShortString();
		verify(pjp).getSignature();
		verify(pjp).proceed();
		verify(msStats).update(anyString(), anyLong());
	}

	@Test
	public void testDoBasicProfilingMsStatsNull() throws Throwable {
		// Set Expectations
		ProceedingJoinPoint pjp = mock(ProceedingJoinPoint.class);
		Signature signature = mock(Signature.class);
		when(signature.toShortString()).thenReturn("SomeClass.doSomething()");
		when(pjp.getSignature()).thenReturn(signature);
		when(pjp.proceed()).thenReturn("response");
		ReflectionTestUtils.setField(profiler, "msStats", null);

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
		// Expectations
		when(msStats.printDelimOutput(anyString())).thenReturn("BlahBlah");
		
		assertNotNull(profiler.getDelimitedHogStats());
		
		// verify
		verify(msStats).printDelimOutput(anyString());
	}

	@Test
	public void testGetDelimitedHogStatsException() throws Exception {
		// Expectations
		when(msStats.printDelimOutput(anyString())).thenThrow(new Exception());
		
		assertTrue(profiler.getDelimitedHogStats().contains("Unable to produce delimited hog stats:"));
		
		// verify
		verify(msStats).printDelimOutput(anyString());
	}

	@Test
	public void testGetHtmlHogStats() {
		profiler.getHtmlHogStats();
	}

	@Test
	public void testSetStatsDelimiter() {
		profiler.setStatsDelimiter(",");
	}

	@Test
	public void testToString() throws Exception {
		// Expectations
		when(msStats.printDelimOutput(anyString())).thenReturn("BlahBlah");
		
		assertNotNull(profiler.toString());
		
		// verify
		verify(msStats).printDelimOutput(anyString());
	}

	@Test
	public void testClearStats() {
		profiler.clearStats();
	}

}
