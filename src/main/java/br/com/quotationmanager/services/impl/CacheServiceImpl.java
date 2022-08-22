package br.com.quotationmanager.services.impl;

import br.com.quotationmanager.model.dto.StockManagerDTO;
import br.com.quotationmanager.services.CacheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CacheServiceImpl implements CacheService {

    @Autowired
    private Cache cache;

    public void save(String key, List<StockManagerDTO> stock) {
        cache.put(key, stock);
    }

    public List<StockManagerDTO> find(String key) {
        return cache.get(key, List.class);
    }
}
