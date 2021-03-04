package com.ss.microservices.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import io.github.resilience4j.retry.annotation.Retry;

@RestController
public class CircuitBreakerController {

	Logger logger = LoggerFactory.getLogger(CircuitBreakerController.class);

	@GetMapping(value = "/breaker")
	@Retry(name = "default", fallbackMethod = "hardCodedMethod")
	public String simpleAPI() {
		logger.info("simpleAPI CALLED");
		ResponseEntity<String> responseEntity = new RestTemplate().getForEntity("", String.class);
		return responseEntity.getBody();
	}

	public String hardCodedMethod(Exception exception) {
		return "fall-back response";
	}
}
