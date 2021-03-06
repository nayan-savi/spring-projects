package com.stock.sg.sgstockprice.repository;

import com.stock.sg.sgstockprice.model.Stock;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;

@Repository
public interface StockRepository extends CrudRepository<Stock, Long> {
    List<Stock> findAllBySymbol(String symbol);
    List<Stock> getStocksByDateGreaterThanEqualAndDateLessThan(Date from_date, Date to_date);
    @Query(value = "select distinct s_symbol from stock_price", nativeQuery = true)
    List<String> getSymbol();
}
