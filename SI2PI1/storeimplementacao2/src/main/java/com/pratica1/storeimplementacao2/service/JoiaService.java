package com.pratica1.storeimplementacao2.service;

import com.pratica1.storeimplementacao2.Exception.BadRequestException;
import com.pratica1.storeimplementacao2.Exception.NotFoundException;
import com.pratica1.storeimplementacao2.model.Joia;
import com.pratica1.storeimplementacao2.repository.IJoiaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class JoiaService implements IJoiaService {

    @Autowired
    IJoiaRepository joiaRepo;

    public Long create(Joia newJoia) {
        if(newJoia.getId() > 0) {
            throw new BadRequestException("Jóia já existe!");
        }
        Joia joiaNova = joiaRepo.save(newJoia);
        return joiaNova.getId();
    }

    public Joia update(Long id, Map<String, String> changes) {
        Joia joia = joiaRepo.findById(id)
                        .orElseThrow(
                                () -> new NotFoundException("Usuário não encontrado, id: " + id)
                        );

        Class<?> c = joia.getClass();
        changes.forEach((attribute, value) -> {
            String attr = attribute.substring(0,1).toUpperCase() + attribute.substring(1).toLowerCase();
            try {
                c.getDeclaredMethod("set" + attr, value.getClass()).invoke(joia, value);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        joiaRepo.save(joia);
        return joia;
    }

    public List<Joia> getAll() {
        return StreamSupport.stream(joiaRepo.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    public Void remove(Long id) {
        joiaRepo.deleteById(id);
        return null;
    }

}
