package app.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.mock.web.MockFilterChain;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;

import app.filter.SimpleCORSFilter;

public class SimpleCORSFilterTest {

	private SimpleCORSFilter simpleCORSFilter;
	
	@Before
	public void setUp() throws Exception {
		simpleCORSFilter = new SimpleCORSFilter();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testDoFilter() throws IOException, ServletException {
		ServletRequest req = new MockHttpServletRequest();
		ServletResponse res = new MockHttpServletResponse();
		FilterChain chain = new MockFilterChain();
		simpleCORSFilter.doFilter(req , res, chain);
	}

	@Test
	public void testInit() {
		simpleCORSFilter.init(null);
	}

	@Test
	public void testDestroy() {
		simpleCORSFilter.destroy();
	}

}
