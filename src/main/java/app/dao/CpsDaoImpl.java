package app.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import app.model.CpsProfile;

@Service
public class CpsDaoImpl implements CpsDao {

	@Value("${cmi.endpoint}")
	private String cpsEndpoint;

	@Autowired
	private RestTemplate restTemplate;

	@Override
	public CpsProfile getCpsData(final String screenName, String accessToken) {
		final String cpsUrl = getCpsUrl(screenName, accessToken);
		return restTemplate.getForObject(cpsUrl, CpsProfile.class);
	}

	private String getCpsUrl(final String screenName, final String accessToken) {
		return String.format("%s/customer/%s/profile?access_token=%s", cpsEndpoint, screenName, accessToken);
	}

}
