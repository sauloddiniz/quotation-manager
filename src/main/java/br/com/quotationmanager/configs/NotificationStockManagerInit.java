package br.com.quotationmanager.configs;

import br.com.quotationmanager.clients.stock_manager_notification.StockManagerNotificationService;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class NotificationStockManagerInit implements ApplicationRunner {

    final
    StockManagerNotificationService service;

    public NotificationStockManagerInit(StockManagerNotificationService service) {
        this.service = service;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        service.saveStockManagerNotification();
    }
}
