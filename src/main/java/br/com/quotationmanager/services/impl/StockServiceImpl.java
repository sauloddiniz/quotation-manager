package br.com.quotationmanager.services.impl;

import br.com.quotationmanager.clients.stock_manager.StockManagerService;
import br.com.quotationmanager.clients.stock_manager_notification.StockManagerNotificationService;
import br.com.quotationmanager.exceptions.NotFoundException;
import br.com.quotationmanager.model.dto.StockManagerDTO;
import br.com.quotationmanager.model.entity.Stock;
import br.com.quotationmanager.repository.StockRepository;
import br.com.quotationmanager.services.StockService;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StockServiceImpl implements StockService {

    private final StockRepository repository;

    private final StockManagerService stockManagerService;

    private final StockManagerNotificationService stockManagerNotificationService;

    public StockServiceImpl(StockRepository repository, StockManagerService stockManagerService, StockManagerNotificationService stockManagerNotificationService) {
        this.repository = repository;
        this.stockManagerService = stockManagerService;
        this.stockManagerNotificationService = stockManagerNotificationService;
    }

    @Override
    @Cacheable(value = "quotes-local")
    public List<Stock> findAll() {
        return repository.findAll();
    }

    @Override
    public void save(Stock stock) {

        List<StockManagerDTO> stocks = stockManagerService.findAllStockManagerDto();

        if (stocks.isEmpty() || isStockIdNotPresent(stocks, stock.getStockId())) {
            throw new NotFoundException("Stock Manager not found");
        }
        repository.save(stock);
        stockManagerNotificationService.saveStockManagerNotification();
    }

    private boolean isStockIdNotPresent(List<StockManagerDTO> stocks, String id) {
        return !stocks.stream().filter(e -> e.getId().equals(id)).findFirst().isPresent();
    }

    @Override
    public List<Stock> findByStockId(String stockId) {
        return repository.findByStockId(stockId);
    }
}
