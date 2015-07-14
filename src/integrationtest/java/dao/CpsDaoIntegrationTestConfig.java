package dao;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.Profile;

import app.configuration.RestTemplateConfiguration;
import app.dao.CpsDao;
import app.dao.CpsDaoImpl;

@Configuration
@ImportResource({"classpath*:spring/properties-context.xml"
}) 
@Import(value={RestTemplateConfiguration.class})
@Profile("integrationtesting")
public class CpsDaoIntegrationTestConfig {
	@Bean
	public CpsDao cpsDao() {
		return new CpsDaoImpl();
	}
}