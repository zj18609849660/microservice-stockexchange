package com.microservice.stock.stockexchange.rest;

import com.microservice.stock.stockexchange.model.StockExchange;
import com.microservice.stock.stockexchange.service.StockExchangeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/stockexchange")
public class StockExchangeController {
    @Autowired
    StockExchangeService stockExchangeService;

    @GetMapping("/all")
    public List<StockExchange> getAllStockExchanges() {
        return stockExchangeService.retrieveAllStockExchanges();
    }

    @PostMapping("/add")
    public Map<String, String> addNewStockExchange(@RequestBody StockExchange stockExchange) {
        Map<String, String> resultMap = new HashMap<>();
        stockExchangeService.addNewStockExchanges(stockExchange);
        resultMap.put("addStockExchangeStatus", "successful");
        return resultMap;
    }

}
