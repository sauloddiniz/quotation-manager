package br.com.quotationmanager.controller;

import br.com.quotationmanager.model.entity.Stock;
import br.com.quotationmanager.model.dto.StockDTO;
import br.com.quotationmanager.services.impl.StockServiceImpl;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "stock")
public class StockController {

    private final StockServiceImpl service;

    final ModelMapper mapper;

    public StockController(StockServiceImpl service, ModelMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @GetMapping
    public ResponseEntity<List<StockDTO>> listStokes() {

        List<Stock> list = service.findAll();

        if (list.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        List<StockDTO> listDto = list.stream().map(e -> mapper.map(e, StockDTO.class))
                .collect(Collectors.toList());

        return ResponseEntity.ok().body(listDto);
    }

    @GetMapping(value = {"/stockId"})
    public ResponseEntity<List<StockDTO>> findAllByStokeId(@PathParam("stockId") String stockId) {
        List<Stock> list = service.findByStockId(stockId);

        if (list.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        List<StockDTO> listDto = list.stream().map(e -> mapper.map(e, StockDTO.class))
                .collect(Collectors.toList());
        return ResponseEntity.ok().body(listDto);
    }

    @PostMapping
    public ResponseEntity<StockDTO> save(@RequestBody StockDTO quotesDTO) {
        Stock quote = mapper.map(quotesDTO, Stock.class);
        service.save(quote);
        return ResponseEntity.created(URI.create(quote.getId().toString())).build();
    }
}
