package com.ss.microservices.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ss.microservices.dao.CurrencyExchangeRepository;
import com.ss.microservices.dto.CurrencyExchange;

@RestController
@RequestMapping("currency-exchange")
public class CurrencyExchangeController {

//	@Value("${server.port}")
//	private String port;

	@Autowired
	Environment environment;

	@Autowired
	CurrencyExchangeRepository currencyExchangeRepository;

	@GetMapping(value = "/from/{from}/to/{to}")
	public CurrencyExchange exchange(@PathVariable String from, @PathVariable String to) {
		CurrencyExchange currencyExchange = currencyExchangeRepository.findByFromAndTo(from, to);
		if(currencyExchange == null) {
			throw new RuntimeException(String.format("No matching data found for %s & %s", from, to));
		}
		currencyExchange.setPort(environment.getProperty("server.port"));
		return currencyExchange;

	}

}
