package br.com.quotationmanager.clients.stock_manager;

import br.com.quotationmanager.model.dto.StockManagerDTO;
import br.com.quotationmanager.services.CacheService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class StockManagerImpl implements StockManagerService {

    @Value("${key.cache}")
    private String keyCache;

    @Autowired
    StockManagerClient client;

    @Autowired
    CacheService cacheService;

    @Override
    public List<StockManagerDTO> getStockManager() {

        if (cacheService.find(keyCache) == null) {
            List<StockManagerDTO> list = client.getStockManager();
            if (!list.isEmpty())
                cacheService.save(keyCache, list);
            return list;
        } else {
            return cacheService.find(keyCache);
        }
    }

    @Override
    public List<StockManagerDTO> getByIdStockManager(String id) {
        return client.getByIdStockManager(id);
    }
}
