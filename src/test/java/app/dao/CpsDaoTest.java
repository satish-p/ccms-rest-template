package app.dao;

import static org.springframework.test.web.client.match.MockRestRequestMatchers.anything;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withSuccess;

import java.util.Properties;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.test.web.client.MockRestServiceServer;
import org.springframework.web.client.RestTemplate;

import app.dao.CpsDao;
import app.dao.CpsDaoImpl;
import app.model.CpsProfile;
import app.utils.JsonUtils;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath*:spring/responses-context.xml"})
public class CpsDaoTest {

	private final Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	private Properties responses;
	
	private CpsDao cpsDao;
	private RestTemplate restTemplate;
	private MockRestServiceServer mockServer;
	
	@Before
    public void setUp() {
		cpsDao = new CpsDaoImpl();
		restTemplate = new RestTemplate();
		ReflectionTestUtils.setField(cpsDao, "restTemplate", restTemplate);
		mockServer = MockRestServiceServer.createServer(restTemplate);
		ReflectionTestUtils.setField(cpsDao, "cpsEndpoint", "http://server.com");

	}

	@Test
	public void testGetCpsProfile() {
    	mockServer.expect(anything()).andRespond(withSuccess(responses.getProperty("cps.response"), MediaType.APPLICATION_JSON));
		final CpsProfile cpsData = cpsDao.getCpsData("spchangeplan3", "");
		logger.debug("CpsData: {}", JsonUtils.toJsonStringNonNull(cpsData));
		Assert.assertNotNull(cpsData);
		Assert.assertNotNull(cpsData.getErrors());
		Assert.assertNotNull(cpsData.getNameValuePairs());
		mockServer.verify();
	}

}
