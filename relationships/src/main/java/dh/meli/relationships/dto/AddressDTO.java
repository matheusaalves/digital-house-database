package dh.meli.relationships.dto;

import dh.meli.relationships.model.Address;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AddressDTO {
    private String location;

    public AddressDTO(Address address) {
        this.location = address.getLocation();
    }
}
