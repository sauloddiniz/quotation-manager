package br.com.quotationmanager.clients.stock_manager;

import br.com.quotationmanager.model.dto.StockManagerDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(
        name = "stoke-manager-client",
        url = "http://localhost:8080/stock"
)
public interface StockManagerClient {

    @GetMapping(
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public List<StockManagerDTO> getStockManager();

    @GetMapping(value = "?id={id}",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public List<StockManagerDTO> getByIdStockManager(@PathVariable("id") String id);
}
