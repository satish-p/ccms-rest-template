package com.aol.cmi.controller;

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

import com.aol.cmi.model.ContentBlock;
import com.aol.cmi.model.ProductSummary;
import com.aol.cmi.service.CatalogService;
import com.aol.cmi.service.DataNotFoundException;

public class CatalogControllerTest {

	private static final String PRODUCT_SKU = "sample";
	private static final String DEFAULT_VIEW_ATTRIBUTES = "desktop";

	private CatalogService catalogService;
	private CatalogController catalogController;
	
	@Before
	public void setup() {
		// Setup controller
		catalogController = new CatalogController();
		catalogService = mock(CatalogService.class);
		ReflectionTestUtils.setField(catalogController, "catalogService", catalogService);

		// Set request
		HttpServletRequest request = new MockHttpServletRequest();
		RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));

	}
	
	@Test
	public void testGetProductString() throws Exception {
		
		// Set Expectations
		when(catalogService.getProductSummary(anyString(), anyString()))
		.thenReturn(createProductSummary(PRODUCT_SKU));
		
		// Do the test
		ProductSummary responseEntity = catalogController.getProduct(PRODUCT_SKU, DEFAULT_VIEW_ATTRIBUTES);
		assertNotNull(responseEntity);

		// Verify
		verify(catalogService).getProductSummary(anyString(), anyString());
	}

	private ProductSummary createProductSummary(String productSku) {
		ProductSummary product = new ProductSummary();
		product.setSku(productSku);
		return product;
	}

	@Test(expected=DataNotFoundException.class)
	public void testGetProductStringNull() throws Exception {
		// Set Expectations
		when(catalogService.getProductSummary(anyString(), anyString()))
		.thenThrow(new DataNotFoundException("Data not found"));
		
		// Do the test
		ProductSummary responseEntity = catalogController.getProduct(PRODUCT_SKU, DEFAULT_VIEW_ATTRIBUTES);
		assertNotNull(responseEntity);

		// Verify
		verify(catalogService).getProductSummary(anyString(), anyString());
	}

	@Test
	public void testGetCmsBlockString() throws Exception {
		
		// Set Expectations
		when(catalogService.getContentBlock(anyString()))
		.thenReturn(createContentBlock("red"));
		
		// Do the test
		ContentBlock responseEntity = catalogController.getContentBlock(PRODUCT_SKU);
		assertNotNull(responseEntity);

		// Verify
		verify(catalogService).getContentBlock(anyString());
	}

	@Test
	public void testGetCmsBlocksString() throws Exception {
		
		// Set Expectations
		when(catalogService.getContentBlocks(anyString()))
		.thenReturn(Arrays.asList(createContentBlock("red")));
		
		// Do the test
		List<ContentBlock> responseEntity = catalogController.getContentBlocks(PRODUCT_SKU);
		assertNotNull(responseEntity);

		// Verify
		verify(catalogService).getContentBlocks(anyString());
	}

	private ContentBlock createContentBlock(String string) {
		ContentBlock contentBlock = new ContentBlock();
		contentBlock.setIdentifier(string);
		return contentBlock;
	}

	@Test
	public void testGetUpsellProducts() throws Exception {
		
		// Set Expectations
		when(catalogService.getUpsellProducts(anyString(), anyString()))
		.thenReturn(Arrays.asList(createProductSummary(PRODUCT_SKU)));
		
		// Do the test
		List<ProductSummary> responseEntity = catalogController.getUpsellProducts(PRODUCT_SKU, DEFAULT_VIEW_ATTRIBUTES);
		assertNotNull(responseEntity);
		assertFalse(responseEntity.isEmpty());

		// Verify
		verify(catalogService).getUpsellProducts(anyString(), anyString());
	}


}
