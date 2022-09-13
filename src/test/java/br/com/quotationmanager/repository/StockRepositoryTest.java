package br.com.quotationmanager.repository;

import br.com.quotationmanager.model.entity.Stock;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;
import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@DataJpaTest
class StockRepositoryTest {

    @Autowired
    private StockRepository repository;

    @Test
    public void saveStock() {

        Stock stock = Stock.builder().stockId("petr4").build();

        Stock stockSaved = repository.save(stock);

        assertNotNull(stockSaved.getId());
    }

}