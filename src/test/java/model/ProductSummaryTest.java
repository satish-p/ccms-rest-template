package model;

import static org.junit.Assert.assertNotNull;
import model.ProductSummary;

import org.junit.Before;
import org.junit.Test;

import utils.JsonUtils;

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
