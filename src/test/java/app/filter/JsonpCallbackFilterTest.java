package app.filter;

import static org.mockito.Mockito.mock;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;

public class JsonpCallbackFilterTest {

	private JsonpCallbackFilter jsonpCallbackFilter;
	
	@Before
	public void setUp() throws Exception {
		jsonpCallbackFilter = new JsonpCallbackFilter();
		jsonpCallbackFilter.setCallbackParameterName("callback");
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testInit() throws ServletException {
		jsonpCallbackFilter.init(null);
	}

	@Test
	public void testDestroy() {
		jsonpCallbackFilter.destroy();
	}

	@Test
	public void testDoFilterNoCallback() throws IOException, ServletException {
		MockHttpServletRequest request = request();
		jsonpCallbackFilter.doFilter(request, response(), chain());
	}

	private MockHttpServletRequest request() {
		MockHttpServletRequest request = new MockHttpServletRequest();
		request.setRequestURI("/profile");
		return request;
	}

	private MockHttpServletResponse response() {
		return new MockHttpServletResponse();
	}

	private FilterChain chain() {
		return mock(FilterChain.class);
	}

	@Test
	public void testDoFilterCallbackNoLogging() throws IOException, ServletException {
		MockHttpServletRequest request = request();
		request.setParameter("callback", "blahblah");
		jsonpCallbackFilter.doFilter(request, response(), chain());
	}

	@Test
	public void testDoFilterCallback() throws IOException, ServletException {
		MockHttpServletRequest request = request();
		request.setParameter("callback", "blahblah");
		jsonpCallbackFilter.doFilter(request, new MockHttpServletResponse(), chain());
	}

}
