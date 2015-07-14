package dao;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.Profile;

import app.configuration.RestTemplateConfiguration;
import app.dao.CatalogDao;
import app.dao.CatalogDaoImpl;

@Configuration
@ImportResource({
	"classpath*:spring/properties-context.xml"
	, "classpath*:spring/catalog-attributes-context.xml"
}) 
@Import(value={RestTemplateConfiguration.class})
@Profile("integrationtesting")
public class CatalogDaoIntegrationTestConfig {
	@Bean
	public CatalogDao catalogDao() {
		return new CatalogDaoImpl();
	}
	

}