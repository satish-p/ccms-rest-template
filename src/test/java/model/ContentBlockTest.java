package model;

import static org.junit.Assert.*;
import model.ContentBlock;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

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
