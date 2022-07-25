package com.pratica1.storeimplementacao2.controller;

import com.pratica1.storeimplementacao2.model.Joia;
import com.pratica1.storeimplementacao2.repository.IJoiaRepository;
import com.pratica1.storeimplementacao2.service.IJoiaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin("*")
public class JoiaController {

    @Autowired
    private IJoiaService joiaService;

    @PostMapping("/joia/inserir")
    public ResponseEntity<Long> create(@RequestBody Joia newJoia) {
        return ResponseEntity.status(HttpStatus.CREATED).body(joiaService.create(newJoia));
    }

    @GetMapping("/joias")
    public ResponseEntity<List<Joia>> getAll() {
        return ResponseEntity.ok(joiaService.getAll());
    }

    @DeleteMapping("/joia/excluir")
    public ResponseEntity<Void> delete(@RequestParam Long numero_identificacao) {
        return ResponseEntity.ok(joiaService.remove(numero_identificacao));
    }

    @PutMapping("joia/atualizar")
    public ResponseEntity<Joia> update(@RequestParam Long numero_identificacao, @RequestBody Map<String, String> changes) {
        return ResponseEntity.ok(joiaService.update(numero_identificacao, changes));
    }
}
