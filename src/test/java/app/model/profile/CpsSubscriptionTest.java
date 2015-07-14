package app.model.profile;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import app.dao.CpsDaoStub;
import app.model.profile.CpsSubscription;

public class CpsSubscriptionTest {

	private CpsSubscription cpsSubscription;
	
	@Before
	public void setUp() throws Exception {
		cpsSubscription = CpsDaoStub.createSubscription();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testHashCode() {
		assertNotNull(cpsSubscription.hashCode());
	}

	@Test
	public void testGetName() {
		assertNotNull(cpsSubscription.getName());
	}

	@Test
	public void testGetStatus() {
		assertNotNull(cpsSubscription.getStatus());
	}

	@Test
	public void testGetEffective_date() {
		assertNotNull(cpsSubscription.getEffectiveDate());
	}

	@Test
	public void testGetProductClass() {
		assertNotNull(cpsSubscription.getProductClass());
	}

	@Test
	public void testGetProductFamily() {
		assertNotNull(cpsSubscription.getProductFamily());
	}

	@Test
	public void testEqualsObject() {
		assertFalse(cpsSubscription.equals(new CpsSubscription()));
	}

	@Test
	public void testGetSvuProdId() {
		assertNotNull(cpsSubscription.getSvuProdId());
	}

}
