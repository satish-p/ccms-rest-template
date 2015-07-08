package com.aol.cmi.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aol.cmi.stats.Profiler;

@RestController
public class StatsController {

	private static final String CMI_API_OK = "OK";
	private boolean shouldShutdown;
	private static final Logger LOGGER = LoggerFactory.getLogger(StatsController.class);
	
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
	
	@RequestMapping("_ns_/nstest.html.stop")
	public String shutdown() {
		LOGGER.info("Taking service out of load balancer rotation");
		this.shouldShutdown = true;
		return CMI_API_OK;
	}
	
	@RequestMapping("_ns_/nstest.html.start")
	public String startup() {
		LOGGER.info("Putting service into load balancer rotation");
		this.shouldShutdown = false;
		return CMI_API_OK;
	}
	

}
