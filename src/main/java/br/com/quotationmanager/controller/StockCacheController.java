package br.com.quotationmanager.controller;

import br.com.quotationmanager.clients.stock_manager_notification.StockManagerNotificationService;
import br.com.quotationmanager.services.CacheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("stockcache")
public class StockCacheController {

    @Value("${key.cache}")
    private String keyCache;

    @Autowired
    private StockManagerNotificationService stockManagerNotificationService;

    @Autowired
    CacheService cacheService;

    public ResponseEntity<?> deleteCache() {
        cacheService.save(keyCache, null);
        stockManagerNotificationService.saveStockManagerNotification();
        return ResponseEntity.ok().build();
    }

}
