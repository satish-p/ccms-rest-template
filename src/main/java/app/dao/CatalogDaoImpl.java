package app.dao;

import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import app.model.ContentBlock;
import app.model.ProductSummary;

@Service
public class CatalogDaoImpl implements CatalogDao {

	@Value("${cmi.endpoint}")
	private String ecommerceEndpoint;

	@Autowired
	protected RestTemplate restTemplate;

	private static final Logger LOGGER = LoggerFactory.getLogger(CatalogDaoImpl.class);

	@Override
	public ProductSummary getProduct(String id) {
		LOGGER.debug("Get Ecommerce Product {}", id);
		String url = String.format("%s/catalog/products/%s?view=avocado", ecommerceEndpoint, id);
		return restTemplate.getForObject(url, ProductSummary.class);
	}

	@Override
	public ContentBlock getCmsBlock(String id) {
		return restTemplate.getForObject(getCmsBlockUrl(id), ContentBlock.class);
	}

	private String getCmsBlockUrl(String id) {
		return String.format("%s/catalog/cms/%s", ecommerceEndpoint, id);
	}

	@Override
	public List<ContentBlock> getCmsBlocks(String prefix) {
		String url = String.format("%s/catalog/cms?prefix=%s", ecommerceEndpoint, prefix);
		return Arrays.asList(restTemplate.getForObject(url, ContentBlock[].class));
	}

	@Override
	public List<ProductSummary> getUpsellProducts(String id) {
		String url = String.format("%s/catalog/products/%s/upsell?view=avocado", ecommerceEndpoint, id);
		return Arrays.asList(restTemplate.getForObject(url, ProductSummary[].class));
	}

	@Override
	public List<ProductSummary> getXsellProducts(String id) {
		String url = String.format("%s/catalog/products/%s/related?view=avocado", ecommerceEndpoint, id);
		return Arrays.asList(restTemplate.getForObject(url, ProductSummary[].class));
	}

}
