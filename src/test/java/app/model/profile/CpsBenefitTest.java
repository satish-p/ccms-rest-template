package app.model.profile;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import app.dao.CpsDaoStub;
import app.model.profile.CpsBenefit;

public class CpsBenefitTest {

	private CpsBenefit cpsBenefit;
	
	@Before
	public void setUp() throws Exception {
		cpsBenefit = CpsDaoStub.createBenefit();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testHashCode() {
		assertNotNull(cpsBenefit.hashCode());
	}

	@Test
	public void testGetName() {
		assertNotNull(cpsBenefit.getName());
	}

	@Test
	public void testGetStatus() {
		assertNotNull(cpsBenefit.getStatus());
	}

	@Test
	public void testGetEffective_date() {
		assertNotNull(cpsBenefit.getEffectiveDate());
	}

	@Test
	public void testGetProductClass() {
		assertNotNull(cpsBenefit.getProductClass());
	}

	@Test
	public void testGetProductFamily() {
		assertNotNull(cpsBenefit.getProductFamily());
	}

	@Test
	public void testEqualsObject() {
		assertFalse(cpsBenefit.equals(new CpsBenefit()));
	}

	@Test
	public void testGetSvuProdId() {
		assertNotNull(cpsBenefit.getSvuProdId());
	}

}
