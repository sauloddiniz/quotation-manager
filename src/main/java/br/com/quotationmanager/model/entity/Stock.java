package br.com.quotationmanager.model.entity;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Map;
import java.util.UUID;

@Entity
@Table(name = "stoke")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode
public class Stock implements Serializable {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(name = "id", updatable = false, nullable = false, columnDefinition = "VARCHAR(36)")
    @Type(type = "uuid-char")
    private UUID id;

    @Column(name = "stockId")
    private String stockId;

    @ElementCollection
    @CollectionTable(name = "stock_quotes_mapping",
            joinColumns = { @JoinColumn(name = "stockId", referencedColumnName = "id")})
    @MapKeyColumn(name = "stock_quote")
    private Map<LocalDate,Double> quotes;

    public Stock(String id, String stockId) {
        this.id = UUID.fromString(id);
        this.stockId = stockId;
    }
}
