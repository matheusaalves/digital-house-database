package com.implementation1.database.demo.controller;

import com.implementation1.database.demo.model.UserBD;
import com.implementation1.database.demo.service.UserService;
import org.apache.catalina.User;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/user")
public class UserBdController {

    @Autowired
    private UserService service;

    @GetMapping("/{id}")
    public ResponseEntity<UserBD> buscarPorId(@PathVariable long id) {
//        UserBD userFound = service.getUserById(id).get();
        UserBD userFound = service.getUserById(id);
        return ResponseEntity.ok(userFound);
    }

    @GetMapping("/email/{email}")
    public ResponseEntity<UserBD> buscarPorEmail(@PathVariable String email) {
//        UserBD userFound = service.getUserById(id).get();
        UserBD userFound = service.findByEmail(email);
        return ResponseEntity.ok(userFound);
    }

    @GetMapping
    public ResponseEntity<List<UserBD>> listAll() {
        return ResponseEntity.ok(service.listAll());
    }

    @PostMapping
    public ResponseEntity<UserBD> insertNewUser(@RequestBody UserBD user) {
        // Poderia validar se existe id por aqui tb
        return ResponseEntity.status(HttpStatus.CREATED).body(service.insertUser(user));
    }

    @PutMapping
    public ResponseEntity<UserBD> updateUser(@RequestBody UserBD user) {
        return ResponseEntity.ok(service.update(user));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<UserBD> updateUser(@PathVariable long id, @RequestBody Map<String, String> changes) {
        return ResponseEntity.ok(service.updatePartial(id, changes));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable long id) {
        service.getUserById(id);
        service.deleteUser(id);
        return ResponseEntity.noContent().build();
    }
}
