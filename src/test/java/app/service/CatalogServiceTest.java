package app.service;

import static org.mockito.Matchers.*;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.util.ReflectionTestUtils;

import app.dao.CatalogDao;
import app.model.ContentBlock;
import app.model.ProductSummary;
import app.service.CatalogService;
import app.service.CatalogServiceImpl;

public class CatalogServiceTest {

	private CatalogService catalogService;
	
	@Mock
	private CatalogDao catalogDao;
	
	@Before
	public void setUp() throws Exception {
		catalogService = new CatalogServiceImpl();
		
		MockitoAnnotations.initMocks(this);
		ReflectionTestUtils.setField(catalogService, "catalogDao", catalogDao);
	}

	@Test
	public void testGetProductSummary() {
		// Set Expectations
		when(catalogDao.getProduct(anyString())).thenReturn(createProduct("redbox-dvd-rental"));

		final ProductSummary productSummary = catalogService.getProductSummary("redbox-dvd-rental");
		Assert.assertNotNull(productSummary.getSku());

		// Verify
		verify(catalogDao).getProduct(anyString());
	}

	private ProductSummary createProduct(String sku) {
		ProductSummary product = new ProductSummary();
		product.setSku(sku);
		return product;
	}

	@Test
	public void testGetCmsBlock() {
		// Set Expectations
		when(catalogDao.getCmsBlock(anyString())).thenReturn(createCmsBlock("redbox-dvd-rental"));

		final ContentBlock contentBlock = catalogService.getContentBlock("redbox-dvd-rental");
		Assert.assertNotNull(contentBlock.getIdentifier());

		// Verify
		verify(catalogDao).getCmsBlock(anyString());
	}

	private ContentBlock createCmsBlock(String identifier) {
		ContentBlock contentBlock = new ContentBlock();
		contentBlock.setIdentifier(identifier);
		return contentBlock;
	}

	@Test
	public void testGetCmsBlocks() {
		// Set Expectations
		when(catalogDao.getCmsBlocks(anyString())).thenReturn(Arrays.asList(createCmsBlock("redbox-dvd-rental")));

		final List<ContentBlock> contentBlock = catalogService.getContentBlocks("redbox-dvd-rental");
		Assert.assertFalse(contentBlock.isEmpty());

		// Verify
		verify(catalogDao).getCmsBlocks(anyString());
	}

	@Test
	public void testGetUpsellProducts() {
		// Set Expectations
		when(catalogDao.getUpsellProducts(anyString())).thenReturn(Arrays.asList(createProduct("redbox-dvd-rental")));

		final List<ProductSummary> summaries = catalogService.getUpsellProducts("redbox-dvd-rental");
		Assert.assertNotNull(summaries);
		Assert.assertFalse(summaries.isEmpty());

		// Verify
		verify(catalogDao).getUpsellProducts(anyString());
	}

	@Test
	public void testGetXsellProducts() {
		// Set Expectations
		when(catalogDao.getXsellProducts(anyString())).thenReturn(Arrays.asList(createProduct("redbox-dvd-rental")));

		final List<ProductSummary> summaries = catalogService.getXsellProducts("redbox-dvd-rental");
		Assert.assertNotNull(summaries);
		Assert.assertFalse(summaries.isEmpty());

		// Verify
		verify(catalogDao).getXsellProducts(anyString());
	}

}
