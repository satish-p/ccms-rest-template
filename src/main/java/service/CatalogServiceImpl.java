package service;

import java.util.List;

import model.ContentBlock;
import model.ProductSummary;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import dao.CatalogDao;

@Service
public class CatalogServiceImpl implements CatalogService {

	@Autowired
	private CatalogDao catalogDao;

	@Override
	@Cacheable("products")
	public ProductSummary getProductSummary(String id, String view) {
		return catalogDao.getProduct(id);
	}

	@Override
	@Cacheable("cms")
	public ContentBlock getContentBlock(String id) {
		return catalogDao.getCmsBlock(id);
	}

	@Override
	public List<ProductSummary> getUpsellProducts(String id, String view) {
		return catalogDao.getUpsellProducts(id);
	}

	@Override
	public List<ContentBlock> getContentBlocks(String prefix) {
		return catalogDao.getCmsBlocks(prefix);
	}

}
