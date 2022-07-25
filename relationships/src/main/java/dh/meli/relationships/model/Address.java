package dh.meli.relationships.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String location;

    @OneToOne // Padrão é o lazy para esse tipo de relacionamento
    @JoinColumn(name = "id_author")
    @JsonIgnoreProperties("address")
    private Author author;
}