package app.controller;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import app.model.ContentBlock;
import app.model.ProductSummary;
import app.service.CatalogService;

/**
 * Handles requests for the application home page.
 * Return product as json
 */
@RestController
@RequestMapping(value="/catalog", produces=MediaType.APPLICATION_JSON_VALUE)
public class CatalogController {

	private static final Logger LOGGER = LoggerFactory.getLogger(CatalogController.class);

	@Autowired
	private CatalogService catalogService;
	
	@RequestMapping(value = "/products/{id}", method = RequestMethod.GET)
	public ProductSummary getProduct(@PathVariable("id") final String id) {
		
		LOGGER.debug("Getting product {}", id);
		ProductSummary productSummary = catalogService.getProductSummary(id);
		
		// Link to local
		productSummary.removeLinks();
		productSummary.add(linkTo(methodOn(CatalogController.class).getProduct(id)).withSelfRel());
		productSummary.add(linkTo(methodOn(CatalogController.class).getUpsellProducts(id)).withRel("upsell"));
		return productSummary;
	}

	@RequestMapping(value = "/cms", method = RequestMethod.GET)
	public List<ContentBlock> getContentBlocks(
			@RequestParam("prefix") final String prefix) {
		
		List<ContentBlock> contentBlocks = catalogService.getContentBlocks(prefix);
		
		// Links
		contentBlocks.forEach(cb -> {
			cb.removeLinks();
			cb.add(linkTo(methodOn(CatalogController.class).getContentBlock(cb.getIdentifier())).withRel(cb.getIdentifier()));
		});
		return contentBlocks;
	}


	@RequestMapping(value = "/cms/{id}", method = RequestMethod.GET)
	public ContentBlock getContentBlock(
			@PathVariable("id") final String id) {
		
		ContentBlock contentBlock = catalogService.getContentBlock(id);
		
		// Links
		contentBlock.removeLinks();
		contentBlock.add(linkTo(methodOn(CatalogController.class).getContentBlock(id)).withSelfRel());
		return contentBlock;
	}

	@RequestMapping(value = "/products/{id}/upsell", method = RequestMethod.GET)
	public List<ProductSummary> getUpsellProducts(@PathVariable("id") final String id) {
		
		return catalogService.getUpsellProducts(id);
	}

}
