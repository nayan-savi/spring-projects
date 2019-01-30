package com.stock.sg.sgstockprice.service;

import com.stock.sg.sgstockprice.model.Stock;
import com.stock.sg.sgstockprice.repository.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/stock")
public class StockPriceService {

    @Autowired
    private StockRepository stockRepository;

    @GetMapping("/{symbol}")
    public List<Stock> getStocks(@PathVariable String symbol){
        return stockRepository.findAllBySymbol(symbol);
    }
}
