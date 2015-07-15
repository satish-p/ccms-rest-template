package app.controller;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import app.model.ContentBlock;
import app.service.CatalogService;

/**
 * Handles requests for the application home page.
 * Return product as json
 */
@RestController
@RequestMapping(value="/catalog/cms", produces=MediaType.APPLICATION_JSON_VALUE)
public class CmsController {

	@Autowired
	private CatalogService catalogService;
	
	@RequestMapping(method = RequestMethod.GET)
	public List<ContentBlock> getContentBlocks(
			@RequestParam("prefix") final String prefix) {
		
		List<ContentBlock> contentBlocks = catalogService.getContentBlocks(prefix);
		
		// Links
		contentBlocks.forEach(cb -> {
			cb.removeLinks();
			cb.add(linkTo(methodOn(CmsController.class).getContentBlock(cb.getIdentifier())).withRel(cb.getIdentifier()));
		});
		return contentBlocks;
	}


	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ContentBlock getContentBlock(
			@PathVariable("id") final String id) {
		
		ContentBlock contentBlock = catalogService.getContentBlock(id);
		
		// Links
		contentBlock.removeLinks();
		contentBlock.add(linkTo(methodOn(CmsController.class).getContentBlock(id)).withSelfRel());
		return contentBlock;
	}

}
