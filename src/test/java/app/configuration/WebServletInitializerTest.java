package app.configuration;

import static org.mockito.Mockito.mock;

import org.junit.Test;
import org.springframework.boot.builder.SpringApplicationBuilder;

import app.configuration.WebServletInitializer;

public class WebServletInitializerTest {

	private WebServletInitializer initializer = new WebServletInitializer();

	@Test
	public void testConfigureSpringApplicationBuilder() {
		SpringApplicationBuilder application = mock(SpringApplicationBuilder.class);
		initializer.configure(application);
	}

}
