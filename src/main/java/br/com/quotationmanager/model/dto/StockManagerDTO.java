package br.com.quotationmanager.model.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class StockManagerDTO implements Serializable {
    private String id;
    private String description;
}
