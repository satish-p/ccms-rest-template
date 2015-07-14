package app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import app.dao.CatalogDao;
import app.model.ContentBlock;
import app.model.ProductSummary;

@Service
public class CatalogServiceImpl implements CatalogService {

	@Autowired
	private CatalogDao catalogDao;

	@Override
	@Cacheable("products")
	public ProductSummary getProductSummary(String id) {
		return catalogDao.getProduct(id);
	}

	@Override
	public List<ProductSummary> getUpsellProducts(String id) {
		return catalogDao.getUpsellProducts(id);
	}

	@Override
	public List<ProductSummary> getXsellProducts(String id) {
		return catalogDao.getXsellProducts(id);
	}

	@Override
	@Cacheable("cms")
	public ContentBlock getContentBlock(String id) {
		return catalogDao.getCmsBlock(id);
	}

	@Override
	public List<ContentBlock> getContentBlocks(String prefix) {
		return catalogDao.getCmsBlocks(prefix);
	}

}
