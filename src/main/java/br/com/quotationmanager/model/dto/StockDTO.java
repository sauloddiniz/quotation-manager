package br.com.quotationmanager.model.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Map;
import java.util.UUID;

@Data
public class StockDTO implements Serializable {
    private UUID id;
    private String stockId;
    private Map<String,String> quotes;
}
