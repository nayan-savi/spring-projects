package com.stock.sg.sgstockprice.repository;

import com.stock.sg.sgstockprice.model.Stock;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StockRepository extends CrudRepository<Stock, Long> {
    List<Stock> findAllBySymbol(String symbol);
}
