package app.controller;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import app.model.ProductSummary;
import app.service.CatalogService;

/**
 * Handles requests for the application home page.
 * Return product as json
 */
@RestController
@RequestMapping(value="/catalog/products", produces=MediaType.APPLICATION_JSON_VALUE)
public class ProductController {

	@Autowired
	private CatalogService catalogService;
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ProductSummary getProduct(@PathVariable("id") final String id) {
		
		ProductSummary productSummary = catalogService.getProductSummary(id);
		
		// Link to local
		productSummary.removeLinks();
		productSummary.add(linkTo(methodOn(ProductController.class).getProduct(id)).withSelfRel());
		productSummary.add(linkTo(methodOn(ProductController.class).getUpsellProducts(id)).withRel("upsell"));
		return productSummary;
	}

	@RequestMapping(value = "/{id}/upsell", method = RequestMethod.GET)
	public List<ProductSummary> getUpsellProducts(@PathVariable("id") final String id) {
		return catalogService.getUpsellProducts(id);
	}

	@RequestMapping(value = "/{id}/xsell", method = RequestMethod.GET)
	public List<ProductSummary> getxsellProducts(@PathVariable("id") final String id) {
		return catalogService.getXsellProducts(id);
	}

}
