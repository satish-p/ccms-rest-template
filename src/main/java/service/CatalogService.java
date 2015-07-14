package service;

import java.util.List;

import model.ContentBlock;
import model.ProductSummary;

public interface CatalogService {
	
	/**
	 * Get product summary with the view
	 * @param id
	 * @param view
	 * @return
	 */
	ProductSummary getProductSummary(String id, String view);

	/**
	 * Get CMS block for the given id
	 * @param id
	 * @return
	 */
	ContentBlock getContentBlock(String id);

	/**
	 * Get list of CMS blocks that start with a prefix
	 * @param prefix
	 * @return
	 */
	List<ContentBlock> getContentBlocks(String prefix);

	/**
	 * Upsell products
	 * @param id
	 * @param view
	 * @return
	 */
	List<ProductSummary> getUpsellProducts(String id, String view);
}
