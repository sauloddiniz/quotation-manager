package br.com.quotationmanager.services.impl;

import br.com.quotationmanager.clients.stock_manager.StockManagerService;
import br.com.quotationmanager.clients.stock_manager_notification.StockManagerNotificationService;
import br.com.quotationmanager.model.dto.StockManagerDTO;
import br.com.quotationmanager.model.entity.Stock;
import br.com.quotationmanager.exceptions.NotFoundException;
import br.com.quotationmanager.repository.StockRepository;
import br.com.quotationmanager.services.CacheService;
import br.com.quotationmanager.services.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.CacheManager;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StockServiceImpl implements StockService {

    @Value("${key.cache}")
    private String keyCache;
    @Autowired
    private StockRepository repository;

    @Autowired
    private StockManagerService stockManagerService;

    @Autowired
    private StockManagerNotificationService stockManagerNotificationService;

    @Autowired
    CacheService cacheService;

    @Autowired
    CacheManager cacheManager;

    @Override
    public List<Stock> findAll() {
        return repository.findAll();
    }

    @Override
    public void save(Stock stock) {

        List<StockManagerDTO> stocks = getStockManagerDTOS();

        if (stocks.isEmpty() || isStockIdNotPresent(stocks, stock.getStockId())) {
            throw new NotFoundException("Stock Manager not found");
        }
        repository.save(stock);
        cacheService.save(keyCache, null);
        stockManagerNotificationService.saveStockManagerNotification();
    }

    private boolean isStockIdNotPresent(List<StockManagerDTO> stocks, String id) {
        return !stocks.stream().filter(e -> e.getId().equals(id)).findFirst().isPresent();
    }


    private List<StockManagerDTO> getStockManagerDTOS() {
        return stockManagerService.getStockManager();
    }

    @Override
    public List<Stock> findByStockId(String stockId) {
        return repository.findByStockId(stockId);
    }
}
