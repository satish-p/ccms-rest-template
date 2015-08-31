package app.utils;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import app.utils.JsonUtils;

public class JsonUtilsTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testToJsonString() {
		assertNull(JsonUtils.toJsonString(null));
	}

	@Test
	public void testToJsonStringNonNull() {
		assertNull(JsonUtils.toJsonStringNonNull(null));
	}
	
    @Test
    public void testToJsonStringException() {
        assertNull(JsonUtils.toJsonString(new NoPublicVariables()));
    }

    @Test
    public void testToJsonStringNonNullException() {
        assertNull(JsonUtils.toJsonStringNonNull(new NoPublicVariables()));
    }
}
