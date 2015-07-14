package app.model;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import app.model.ContentBlock;

public class ContentBlockTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testContentBlock() {
		ContentBlock contentBlock = new ContentBlock();
		assertNotNull(contentBlock);
	}

}
