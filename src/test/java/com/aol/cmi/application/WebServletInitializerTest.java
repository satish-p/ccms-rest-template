package com.aol.cmi.application;

import static org.mockito.Mockito.mock;

import org.junit.Test;
import org.springframework.boot.builder.SpringApplicationBuilder;

public class WebServletInitializerTest {

	private WebServletInitializer initializer = new WebServletInitializer();

	@Test
	public void testConfigureSpringApplicationBuilder() {
		SpringApplicationBuilder application = mock(SpringApplicationBuilder.class);
		initializer.configure(application);
	}

}
