package com.pratica1.storeimplementacao2.repository;

import com.pratica1.storeimplementacao2.model.Joia;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IJoiaRepository extends CrudRepository<Joia, Long> {
}
