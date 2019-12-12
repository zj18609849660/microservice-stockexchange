package com.microservice.stock.stockexchange.service;

import com.microservice.stock.stockexchange.dao.StockExchangeRepository;
import com.microservice.stock.stockexchange.entity.StockExchangeEntity;
import com.microservice.stock.stockexchange.model.StockExchange;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class StockExchangeService {
    @Autowired
    StockExchangeRepository stockExchangeRepository;

    @Transactional
    public List<StockExchange> retrieveAllStockExchanges() {
        List<StockExchange> exchangesList = new ArrayList<>();
        List<StockExchangeEntity> exchanges = stockExchangeRepository.findAll();
        if (CollectionUtils.isNotEmpty(exchanges)) {
            exchanges.forEach(exchangeItem -> {
                StockExchange se = new StockExchange();
                BeanUtils.copyProperties(exchangeItem, se);
                exchangesList.add(se);
            });
        }
        return exchangesList;
    }

    @Transactional
    public void addNewStockExchanges(StockExchange stockExchange) {
        StockExchangeEntity stockExchangeEntity = new StockExchangeEntity();
        BeanUtils.copyProperties(stockExchange, stockExchangeEntity);
        stockExchangeRepository.saveAndFlush(stockExchangeEntity);
    }

}
