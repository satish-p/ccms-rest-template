package app.dao;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.web.client.RestTemplate;

import app.dao.CatalogDaoImpl;
import app.model.ContentBlock;
import app.model.ProductSummary;
import static org.mockito.Mockito.*;

public class CatalogDaoImplTest {
	
	private CatalogDaoImpl catalogDaoImpl = new CatalogDaoImpl();
	
	private RestTemplate restTemplate;
	
	@Before
	public void setUp() throws Exception {
		catalogDaoImpl = new CatalogDaoImpl();

		restTemplate = mock(RestTemplate.class);
		ReflectionTestUtils.setField(catalogDaoImpl, "restTemplate", restTemplate);
	}

	@Test
	public void testGetProduct() {
		// Set Expectations
		when(restTemplate.getForObject(anyString(), eq(ProductSummary.class)))
		.thenReturn(new ProductSummary());
		
		// Test
		assertNotNull(catalogDaoImpl.getProduct("sku"));
		
		// Verify
		verify(restTemplate).getForObject(anyString(), eq(ProductSummary.class));
	}

	@Test
	public void testGetCmsBlock() {
		// Set Expectations
		when(restTemplate.getForObject(anyString(), eq(ContentBlock.class)))
		.thenReturn(new ContentBlock());
		
		// Test
		assertNotNull(catalogDaoImpl.getCmsBlock("sku"));
		
		// Verify
		verify(restTemplate).getForObject(anyString(), eq(ContentBlock.class));
	}

	@Test
	public void testGetCmsBlocks() {
		// Set Expectations
		when(restTemplate.getForObject(anyString(), eq(ContentBlock[].class)))
		.thenReturn(new ContentBlock[0]);
		
		// Test
		assertNotNull(catalogDaoImpl.getCmsBlocks("sku"));
		
		// Verify
		verify(restTemplate).getForObject(anyString(), eq(ContentBlock[].class));
	}

	@Test
	public void testGetUpsellProducts() {
		// Set Expectations
		when(restTemplate.getForObject(anyString(), eq(ProductSummary[].class)))
		.thenReturn(new ProductSummary[0]);
		
		// Test
		assertNotNull(catalogDaoImpl.getUpsellProducts("sku"));
		
		// Verify
		verify(restTemplate).getForObject(anyString(), eq(ProductSummary[].class));
	}

	@Test
	public void testGetXsellProducts() {
		// Set Expectations
		when(restTemplate.getForObject(anyString(), eq(ProductSummary[].class)))
		.thenReturn(new ProductSummary[0]);
		
		// Test
		assertNotNull(catalogDaoImpl.getXsellProducts("sku"));
		
		// Verify
		verify(restTemplate).getForObject(anyString(), eq(ProductSummary[].class));
	}

}
