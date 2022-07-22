package com.implementation1.database.demo.repository;

import com.implementation1.database.demo.model.UserBD;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserDbRepo extends CrudRepository<UserBD, Long> { // Mesmo a chave sendo do tipo primário tem que ser passada a classe(Tipo de classe e tipo do primário)
    UserBD findByEmail(String email);
}