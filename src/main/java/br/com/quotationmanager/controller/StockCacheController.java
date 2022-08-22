package br.com.quotationmanager.controller;

import br.com.quotationmanager.clients.stock_manager_notification.StockManagerNotificationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.CacheManager;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("stockcache")
@Slf4j
public class StockCacheController {

    @Value("${key.cache}")
    private String keyCache;

    @Autowired
    private StockManagerNotificationService stockManagerNotificationService;
    @Autowired
    CacheManager cacheManager;

    public ResponseEntity<?> deleteCache() {
        log.debug("Enter request delete cache");
        cacheManager.getCache(keyCache).clear();
        stockManagerNotificationService.saveStockManagerNotification();
        return ResponseEntity.ok().build();
    }

}
