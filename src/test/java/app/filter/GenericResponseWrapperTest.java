package app.filter;

import org.junit.Before;
import org.junit.Test;
import org.springframework.mock.web.MockHttpServletResponse;

import app.filter.GenericResponseWrapper;

public class GenericResponseWrapperTest {

	private GenericResponseWrapper genericResponseWrapper;
	
	@Before
	public void setUp() throws Exception {
		genericResponseWrapper = new GenericResponseWrapper(new MockHttpServletResponse());
	}

	@Test
	public void testGetData() {
		genericResponseWrapper.getData();
	}

	@Test
	public void testGetOutputStream() {
		genericResponseWrapper.getOutputStream();
	}

	@Test
	public void testGetWriter() {
		genericResponseWrapper.getWriter();
	}

	@Test
	public void testGetContentLength() {
		genericResponseWrapper.setContentLength(10);
		genericResponseWrapper.getContentLength();
	}

	@Test
	public void testGetContentType() {
		genericResponseWrapper.setContentType("abc");
		genericResponseWrapper.getContentType();
	}

}
