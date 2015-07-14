package app.controller;

import org.junit.Before;
import org.junit.Test;
import org.springframework.test.util.ReflectionTestUtils;

import app.controller.CustomerController;
import app.service.ProfileService;
import static org.mockito.Mockito.*;

public class CustomerControllerTest {

	private CustomerController customerController;
	private ProfileService profileService;
	
	@Before
	public void setUp() throws Exception {
		customerController = new CustomerController();
		
		profileService = mock(ProfileService.class);
		ReflectionTestUtils.setField(customerController, "profileService", profileService);
	}

	@Test
	public void testGetProfile() {
		customerController.getProfile("viktest3", "");
	}

}
