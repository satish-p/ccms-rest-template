package app.service;


import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.util.ReflectionTestUtils;

import app.dao.CpsDao;
import app.dao.CpsDaoStub;
import app.model.CpsProfile;
import app.service.ProfileService;
import app.service.ProfileServiceImpl;

public class ProfileServiceImplTest {

	private static final String USER_NAME = "spchangeplan3";

	private ProfileService cpsService = new ProfileServiceImpl();

	private CpsDao cpsDao;

	private static final Logger LOGGER = LoggerFactory.getLogger(ProfileServiceImplTest.class);

	@Before
	public void setUp() throws Exception {
		cpsDao = mock(CpsDao.class);
		ReflectionTestUtils.setField(cpsService, "cpsDao", cpsDao);
	}

	@Test
	public void testGetCpsProfileString() {
		// Set Expectations
		when(cpsDao.getCpsData(anyString(), anyString())).thenReturn(CpsDaoStub.createCpsData(USER_NAME));

		final CpsProfile cpsData = cpsService.getProfile(USER_NAME, "");
		LOGGER.debug("CpsData: {}", cpsData);
		Assert.assertNotNull(cpsData);
		
		// Verify
		verify(cpsDao).getCpsData(anyString(), anyString());
	}

}
