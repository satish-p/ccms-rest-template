package app.controller;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.junit.Before;
import org.junit.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import app.model.ContentBlock;
import app.service.CatalogService;

public class CmsControllerTest {

	private CatalogService catalogService;
	private CmsController cmsController;
	
	@Before
	public void setup() {
		// Setup controller
		cmsController = new CmsController();
		catalogService = mock(CatalogService.class);
		ReflectionTestUtils.setField(cmsController, "catalogService", catalogService);

		// Set request
		HttpServletRequest request = new MockHttpServletRequest();
		RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));

	}
	
	@Test
	public void testGetCmsBlockString() throws Exception {
		
		// Set Expectations
		when(catalogService.getContentBlock(anyString()))
		.thenReturn(createContentBlock("red"));
		
		// Do the test
		ContentBlock responseEntity = cmsController.getContentBlock("lifelock");
		assertNotNull(responseEntity);

		// Verify
		verify(catalogService).getContentBlock(anyString());
	}

	@Test
	public void testGetCmsBlocksString() throws Exception {
		
		// Set Expectations
		when(catalogService.getContentBlocks(anyString()))
		.thenReturn(Arrays.asList(createContentBlock("red")));
		
		// Do the test
		List<ContentBlock> responseEntity = cmsController.getContentBlocks("lifelock");
		assertNotNull(responseEntity);

		// Verify
		verify(catalogService).getContentBlocks(anyString());
	}

	private ContentBlock createContentBlock(String string) {
		ContentBlock contentBlock = new ContentBlock();
		contentBlock.setIdentifier(string);
		return contentBlock;
	}

}
