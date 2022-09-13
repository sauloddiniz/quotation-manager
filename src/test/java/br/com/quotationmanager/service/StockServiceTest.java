package br.com.quotationmanager.service;

import br.com.quotationmanager.clients.stock_manager.StockManagerService;
import br.com.quotationmanager.clients.stock_manager_notification.StockManagerNotificationService;
import br.com.quotationmanager.exceptions.NotFoundException;
import br.com.quotationmanager.model.dto.StockManagerDTO;
import br.com.quotationmanager.model.entity.Stock;
import br.com.quotationmanager.repository.StockRepository;
import br.com.quotationmanager.services.impl.StockServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
class StockServiceTest {

    @Mock
    private StockManagerService stockManagerService;

    @Mock
    private StockManagerNotificationService stockManagerNotificationService;

    @Mock
    private StockRepository repository;

    @InjectMocks
    private StockServiceImpl service;

    @Test
    void saveTrowExceptionNotFound() {

        Stock stock = Stock.builder().stockId("PETRA7").build();
        String messageReturn = "Stock Manager not found";

        when(stockManagerService.findAllStockManagerDto()).thenReturn(new ArrayList<StockManagerDTO>());

        Exception exception = assertThrows(NotFoundException.class, () -> service.save(stock));
        assertEquals(messageReturn, exception.getMessage());
    }

    @Test
    void saveSuccess() {

        Stock stock = Stock.builder().stockId("petr4").build();

        when(stockManagerService.findAllStockManagerDto()).thenReturn(List.of(StockManagerDTO.builder().id("petr4").build()));

        assertDoesNotThrow(() -> service.save(stock));
    }

    @Test
    void findAllStock() {

        List<Stock> listStock = List.of(new Stock(UUID.randomUUID().toString(), "petr4"), new Stock(UUID.randomUUID().toString(), "petr7"));

        when(service.findAll()).thenReturn(listStock);

        assertEquals(2, service.findAll().size());
    }

    @Test
    void findEmptyStock() {

        List<Stock> listStock = List.of();

        when(service.findAll()).thenReturn(listStock);

        assertEquals(0, service.findAll().size());
    }


}