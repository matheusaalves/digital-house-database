package dh.meli.relationships.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(length = 50, nullable = false)
    private String titulo;

    @ManyToOne
    @JoinColumn(name = "id_subject")
    @JsonIgnoreProperties("books")
    private Subject subject;

    @ManyToMany(mappedBy = "books")
    @JsonIgnoreProperties("books")
    private List<Author> authors;

}
