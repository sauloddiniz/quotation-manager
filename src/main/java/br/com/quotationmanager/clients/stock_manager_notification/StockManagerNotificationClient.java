package br.com.quotationmanager.clients.stock_manager_notification;

import br.com.quotationmanager.model.dto.StockManagerNotificationDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(
        name = "stoke-manager-notification-client",
        url = "http://localhost:8080/notification"
)
public interface StockManagerNotificationClient {

    @PostMapping(
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public List<StockManagerNotificationDTO> saveStockManagerNotification(@RequestBody StockManagerNotificationDTO dto);
}
