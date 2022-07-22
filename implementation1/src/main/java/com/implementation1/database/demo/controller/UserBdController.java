package com.implementation1.database.demo.controller;

import com.implementation1.database.demo.model.UserBD;
import com.implementation1.database.demo.service.UserService;
import org.apache.catalina.User;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
        Optional<UserBD> userFound = service.getUserById(id);

        if(userFound.isPresent()) {
            return ResponseEntity.ok(userFound.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<UserBD> insertNewUser(@RequestBody UserBD user) {
        // Poderia validar se existe id por aqui tb
        return ResponseEntity.status(HttpStatus.CREATED).body(service.insertUser(user));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable long id) {
        Optional<UserBD> userFound = service.getUserById(id);
        if(userFound.isPresent()) {
            service.deleteUser(id);
            return ResponseEntity.noContent().build();
        } else{
            return ResponseEntity.notFound().build();
        }

    }
}
