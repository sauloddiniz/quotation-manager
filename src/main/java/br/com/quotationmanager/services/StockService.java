package br.com.quotationmanager.services;

import br.com.quotationmanager.model.entity.Stock;

import java.util.List;

public interface StockService {
    List<Stock> findAll();

    void save(Stock quote);

    List<Stock> findByStockId(String stockId);
}
