package dh.meli.relationships.repository;

import dh.meli.relationships.model.Address;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepo extends CrudRepository<Address, Long> {
}
