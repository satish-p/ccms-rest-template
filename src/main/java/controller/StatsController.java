package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import stats.Profiler;

@RestController
public class StatsController {

	private static final String CMI_API_OK = "OK";
	private boolean shouldShutdown;
	
	@Autowired
	private Profiler profiler;
	
	@RequestMapping("/stats")
	public String stats() {
		return profiler.getHtmlHogStats();
	}
	
	@RequestMapping("/clearStats")
	public String clearStats() {
		profiler.reset();
		return profiler.getHtmlHogStats();
	}

	@RequestMapping("_ns_/nstest.html")
	public ResponseEntity<String> nstest() {
		HttpStatus status = shouldShutdown ? HttpStatus.NOT_FOUND : HttpStatus.OK;
		return new ResponseEntity<String>(CMI_API_OK, status);
	}
	
}
