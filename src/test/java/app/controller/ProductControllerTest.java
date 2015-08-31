package app.controller;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.junit.Before;
import org.junit.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import app.model.ProductSummary;
import app.service.CatalogService;

public class ProductControllerTest {

	private static final String PRODUCT_SKU = "sample";

	private CatalogService catalogService;
	private ProductController productController;
	
	@Before
	public void setup() {
		// Setup controller
		productController = new ProductController();
		catalogService = mock(CatalogService.class);
		ReflectionTestUtils.setField(productController, "catalogService", catalogService);

		// Set request
		HttpServletRequest request = new MockHttpServletRequest();
		RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));

	}
	
	@Test
	public void testGetProductString() throws Exception {
		
		// Set Expectations
		when(catalogService.getProductSummary(anyString()))
		.thenReturn(createProductSummary(PRODUCT_SKU));
		
		// Do the test
		ProductSummary responseEntity = productController.getProduct(PRODUCT_SKU);
		assertNotNull(responseEntity);

		// Verify
		verify(catalogService).getProductSummary(anyString());
	}

	private ProductSummary createProductSummary(String productSku) {
		ProductSummary product = new ProductSummary();
		product.setSku(productSku);
		return product;
	}

	@Test
	public void testGetUpsellProducts() throws Exception {
		
		// Set Expectations
		when(catalogService.getUpsellProducts(anyString()))
		.thenReturn(Arrays.asList(createProductSummary(PRODUCT_SKU)));
		
		// Do the test
		List<ProductSummary> responseEntity = productController.getUpsellProducts(PRODUCT_SKU);
		assertNotNull(responseEntity);
		assertFalse(responseEntity.isEmpty());

		// Verify
		verify(catalogService).getUpsellProducts(anyString());
	}

    @Test
    public void testGetXsellProducts() throws Exception {
        
        // Set Expectations
        when(catalogService.getXsellProducts(anyString()))
        .thenReturn(Arrays.asList(createProductSummary(PRODUCT_SKU)));
        
        // Do the test
        List<ProductSummary> responseEntity = productController.getxsellProducts(PRODUCT_SKU);
        assertNotNull(responseEntity);
        assertFalse(responseEntity.isEmpty());

        // Verify
        verify(catalogService).getXsellProducts(PRODUCT_SKU);
    }

}
