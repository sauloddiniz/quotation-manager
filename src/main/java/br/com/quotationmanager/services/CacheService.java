package br.com.quotationmanager.services;

import br.com.quotationmanager.model.dto.StockManagerDTO;

import java.util.List;

public interface CacheService {
    void save(String key, List<StockManagerDTO> stock);

    List<StockManagerDTO> find(String key);
}
