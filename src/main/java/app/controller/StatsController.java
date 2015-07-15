package app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import app.stats.Profiler;

@RestController
public class StatsController {

	private static final String CMI_API_OK = "OK";
	
	@Autowired
	private Profiler profiler;
	
	@RequestMapping(value = "/stats", method = RequestMethod.GET)
	public String stats() {
		return profiler.getHtmlHogStats();
	}
	
	@RequestMapping(value = "/clearStats", method = RequestMethod.GET)
	public String clearStats() {
		profiler.reset();
		return profiler.getHtmlHogStats();
	}

	@RequestMapping(value = "_ns_/nstest.html", method = RequestMethod.GET)
	public ResponseEntity<String> nstest() {
		return new ResponseEntity<String>(CMI_API_OK, HttpStatus.OK);
	}
	
}
