package dh.meli.relationships.dto;

import dh.meli.relationships.model.Author;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AuthorDTO {
    private String name;
    private AddressDTO addressDTO;

    public AuthorDTO(Author author) {
        this.name = author.getName();
        this.addressDTO = new AddressDTO(author.getAddress());
    }
}
