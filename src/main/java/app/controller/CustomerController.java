package app.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import app.model.CpsProfile;
import app.service.ProfileService;

@RestController
@RequestMapping(value="/customer")
public class CustomerController {

	private static final Logger LOGGER = LoggerFactory.getLogger(CustomerController.class);

	@Autowired
	private ProfileService profileService;
	
	@RequestMapping(value = "/{loginId}/profile", method = RequestMethod.GET)
	public CpsProfile getProfile(
			@PathVariable("loginId") final String loginId
			, @RequestParam("access_token") String accessToken) {
		
		LOGGER.debug("Getting profile of '{}'", loginId);
		return profileService.getProfile(loginId, accessToken) ;
	}


}
