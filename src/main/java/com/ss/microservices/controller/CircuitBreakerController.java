package com.ss.microservices.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CircuitBreakerController {

	@GetMapping(value = "/breaker")
	public String simpleAPI() {
		return "Hello";
	}

}
