package app.model.profile;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import app.dao.CpsDaoStub;
import app.model.profile.NameValuePairs;

public class NameValuePairsTest {

	private NameValuePairs nameValuePairs;
	
	@Before
	public void setUp() throws Exception {
		nameValuePairs = CpsDaoStub.createNameValuePairs("viktest3");
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testHashCode() {
		assertNotNull(nameValuePairs.hashCode());
	}

	@Test
	public void testGetSn() {
		assertNotNull(nameValuePairs.getSn());
	}

	@Test
	public void testGetSnList() {
		assertNotNull(nameValuePairs.getSnList());
	}

	@Test
	public void testGetMasterSN() {
		assertNotNull(nameValuePairs.getMasterSN());
	}

	@Test
	public void testGetMasterAccountNumber() {
		assertNotNull(nameValuePairs.getMasterAccountNumber());
	}

	@Test
	public void testGetBid() {
		assertNotNull(nameValuePairs.getBid());
	}

	@Test
	public void testGetSid() {
		assertNotNull(nameValuePairs.getSid());
	}

	@Test
	public void testGetTenure() {
		assertNotNull(nameValuePairs.getTenure());
	}

	@Test
	public void testGetPi() {
		assertNotNull(nameValuePairs.getPi());
	}

	@Test
	public void testGetCategoryId() {
		assertNotNull(nameValuePairs.getCategoryId());
	}

	@Test
	public void testGetIsFreePI() {
		assertNotNull(nameValuePairs.getIsFreePI());
	}

	@Test
	public void testGetMonthlyFee() {
		assertNotNull(nameValuePairs.getMonthlyFee());
	}

	@Test
	public void testGetPendingPI() {
		assertNotNull(nameValuePairs.getPendingPI());
	}

	@Test
	public void testGetPmi() {
		assertNotNull(nameValuePairs.getPmi());
	}

	@Test
	public void testGetZip() {
		assertNotNull(nameValuePairs.getZip());
	}

	@Test
	public void testGetCareStatus() {
		assertNotNull(nameValuePairs.getCareStatus());
	}

	@Test
	public void testGetIsPendingCancel() {
		assertNotNull(nameValuePairs.getIsPendingCancel());
	}

	@Test
	public void testGetFreeMonths() {
		assertNotNull(nameValuePairs.getFreeMonths());
	}

	@Test
	public void testGetSnType() {
		assertNotNull(nameValuePairs.getSnType());
	}

	@Test
	public void testGetEmail() {
		assertNotNull(nameValuePairs.getEmail());
	}

	@Test
	public void testGetOnsBid() {
		assertNotNull(nameValuePairs.getOnsBid());
	}

	@Test
	public void testGetOnsType() {
		assertNotNull(nameValuePairs.getOnsType());
	}

	@Test
	public void testGetGuid() {
		assertNotNull(nameValuePairs.getGuid());
	}

	@Test
	public void testGetIsMFAccount() {
		assertNotNull(nameValuePairs.getIsMFAccount());
	}

	@Test
	public void testGetOsb() {
		assertNotNull(nameValuePairs.getOsb());
	}

	@Test
	public void testGetSubs() {
		assertNotNull(nameValuePairs.getSubs());
	}

	@Test
	public void testEqualsObject() {
		assertNotNull(nameValuePairs.equals(new NameValuePairs()));
	}

	@Test
	public void testToString() {
		assertNotNull(nameValuePairs.toString());
	}

}
