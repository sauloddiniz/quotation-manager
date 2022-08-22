package br.com.quotationmanager.clients.stock_manager_notification;

import br.com.quotationmanager.model.dto.StockManagerNotificationDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StockManagerNotificationServiceImpl implements StockManagerNotificationService {
    @Value("${server.location.port}")
    private String serverPort;

    @Value("${server.location}")
    private String serverAddress;

    @Autowired
    StockManagerNotificationClient client;

    @Override
    public List<StockManagerNotificationDTO> saveStockManagerNotification() {
        StockManagerNotificationDTO dto = new StockManagerNotificationDTO();
        dto.setHost(serverAddress);
        dto.setPort(serverPort);
        return client.saveStockManagerNotification(dto);
    }
}
