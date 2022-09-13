package br.com.quotationmanager.clients.stock_manager;

import br.com.quotationmanager.model.dto.StockManagerDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class StockManagerImpl implements StockManagerService {

    @Autowired
    StockManagerClient client;

    @Override
    public List<StockManagerDTO> getByIdStockManager(String id) {
        return client.getByIdStockManager(id);
    }

    @Override
    @Cacheable(value = "quotes")
    public List<StockManagerDTO> findAllStockManagerDto() {
        return client.getStockManager();
    }
}
