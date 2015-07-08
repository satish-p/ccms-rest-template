package com.aol.cmi.controller;

import static org.mockito.Mockito.mock;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.Profile;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.aol.cmi.service.CatalogService;
import com.aol.cmi.service.ProfileService;
import com.aol.util.hog4j.MsStats;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages={"com.aol.cmi"})
@ImportResource({"classpath:spring/*-context.xml"})
@Profile("testing")
public class MockServiceConfiguration {
	
	@Bean
	public ProfileService cpsServiceImpl() {
		return mock(ProfileService.class);
	}
	
	@Bean
	public CatalogService catalogService() {
		return mock(CatalogService.class);
	}
	
	@Bean
	public MsStats msStats() throws Exception {
		return new MsStats("cmi-test");
	}
}