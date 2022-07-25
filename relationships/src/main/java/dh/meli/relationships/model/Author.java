package dh.meli.relationships.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String name;

    // Nesse caso só está funcionando em cascata o inserir
//    @OneToOne(mappedBy = "author", cascade = CascadeType.PERSIST,fetch = FetchType.LAZY) // author -> Nome do campo na tabela address
    @OneToOne(mappedBy = "author", cascade = CascadeType.ALL,fetch = FetchType.LAZY) // author -> Nome do campo na tabela address
    @JsonIgnoreProperties("author") // ao preencher os dados do address irá ignorar o author(Para evitar loop infinito)
    private Address address;

    @ManyToMany
    @JoinTable(name = "book_author", //nome da tabela de ligação
            joinColumns = @JoinColumn(name = "author_id", referencedColumnName = "id"), // Atributo do Author na tabela de ligação
            inverseJoinColumns = @JoinColumn(name = "book_id", referencedColumnName = "id") // Atributo do Book na tabela de ligação
    )
    @JsonIgnoreProperties("authors")
    private List<Book> books;

}
