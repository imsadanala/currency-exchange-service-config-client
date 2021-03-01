package com.ss.microservices.controller;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ss.microservices.dto.CurrencyExchange;

@RestController
@RequestMapping("currency-exchange")
public class CurrencyExchangeController {
	
	@Value("${server.port}")
	private String port;

	@GetMapping(value = "/from/{from}/USD/to/{to}/INR")
	public CurrencyExchange exchange(@PathVariable String from, @PathVariable String to) {
		CurrencyExchange currencyExchange = new CurrencyExchange(1000L, "INR", "TO", new BigDecimal(50));
		currencyExchange.setPort(port);
		return currencyExchange;

	}

}
