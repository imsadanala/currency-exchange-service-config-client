package com.ss.microservices.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ss.microservices.dto.CurrencyExchange;

public interface CurrencyExchangeRepository extends JpaRepository<CurrencyExchange, Long> {
	
	CurrencyExchange findByFromAndTo(String from, String to);

}
