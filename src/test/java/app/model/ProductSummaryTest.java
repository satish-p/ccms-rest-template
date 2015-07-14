package app.model;

import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;

import app.model.ProductSummary;
import app.utils.JsonUtils;

public class ProductSummaryTest {

	private ProductSummary product;

	@Before
	public void setUp() {
		product = new ProductSummary();
	}
	
	@Test
	public void testProductSummary() {
		product = new ProductSummary();
		JsonUtils.toJsonString(product);
		assertNotNull(product);
	}

}
