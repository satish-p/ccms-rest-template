package app.filter;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

import app.filter.FilterServletOutputStream;

public class FilterServletOutputStreamTest {

	private FilterServletOutputStream filterServletOutputStream;
	
	@Before
	public void setUp() throws Exception {
		filterServletOutputStream = new FilterServletOutputStream(new ByteArrayOutputStream());
	}

	@Test
	public void testWriteInt() throws IOException {
		filterServletOutputStream.write(1);
	}

	@Test
	public void testWriteByteArray() throws IOException {
		filterServletOutputStream.write("test".getBytes());
	}

	@Test
	public void testWriteByteArrayIntInt() throws IOException {
		filterServletOutputStream.write("test".getBytes(), 1, 1);
	}

	@Test
	public void testIsReady() {
		assertFalse(filterServletOutputStream.isReady());
	}
	
	@Test
	public void testSetWriteListener() {
		filterServletOutputStream.setWriteListener(null);
	}
}
