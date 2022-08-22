package br.com.quotationmanager.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Map;
import java.util.UUID;

@Entity
@Table(name = "stoke")
@Data
@AllArgsConstructor
@NoArgsConstructor
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
    @CollectionTable(name = "stoke_quotes_mapping",
            joinColumns = { @JoinColumn(name = "stockId", referencedColumnName = "id")})
    @MapKeyColumn(name = "stoke_quote")
    @Column(name = "quotes")
    private Map<String,String> quotes;
}
