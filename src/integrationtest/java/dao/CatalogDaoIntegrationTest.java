package dao;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import app.dao.CatalogDao;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={CatalogDaoIntegrationTestConfig.class})
@ActiveProfiles("integrationtesting")
public class CatalogDaoIntegrationTest {

	@Autowired
	private CatalogDao catalogDao;

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testGetProduct() {
		Assert.assertNotNull(catalogDao.getProduct("redbox-dvd-rental"));
	}

	@Test
	public void testGetCmsBlock() {
		Assert.assertNotNull(catalogDao.getCmsBlock("gathr-microsite-product-order"));
	}

	@Test
	public void testGetCmsBlocks() {
		Assert.assertNotNull(catalogDao.getCmsBlocks("gathr-microsite"));
	}

	@Test
	public void testGetUpsellProducts() {
		Assert.assertFalse(catalogDao.getUpsellProducts("aol-computer-checkup-1").isEmpty());
	}

	@Test
	public void testGetXsellProducts() {
		Assert.assertFalse(catalogDao.getXsellProducts("aol-computer-checkup-1").isEmpty());
	}


}
