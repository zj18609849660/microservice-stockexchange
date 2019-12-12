package com.microservice.stock.stockexchange.dao;

import com.microservice.stock.stockexchange.entity.StockExchangeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StockExchangeRepository extends JpaRepository<StockExchangeEntity, Long> {
}
