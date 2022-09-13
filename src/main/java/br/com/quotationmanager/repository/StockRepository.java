package br.com.quotationmanager.repository;

import br.com.quotationmanager.model.entity.Stock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface StockRepository extends JpaRepository<Stock, UUID> {
    List<Stock> findByStockId(String stockId);
}
