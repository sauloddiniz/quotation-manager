package br.com.quotationmanager.clients.stock_manager_notification;

import br.com.quotationmanager.model.dto.StockManagerNotificationDTO;

import java.util.List;

public interface StockManagerNotificationService {
    List<StockManagerNotificationDTO> saveStockManagerNotification();
}
