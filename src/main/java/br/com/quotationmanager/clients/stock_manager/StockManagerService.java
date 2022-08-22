package br.com.quotationmanager.clients.stock_manager;

import br.com.quotationmanager.model.dto.StockManagerDTO;

import java.util.List;

public interface StockManagerService {
    List<StockManagerDTO> getStockManager();

    List<StockManagerDTO> getByIdStockManager(String id);
}
