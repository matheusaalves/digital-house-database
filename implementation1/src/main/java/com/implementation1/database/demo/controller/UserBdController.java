package com.implementation1.database.demo.controller;

import com.implementation1.database.demo.model.UserBD;
import com.implementation1.database.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/user")
public class UserBdController {

    @Autowired
    private UserService service;

    @GetMapping("/{id}")
    public ResponseEntity<UserBD> buscarPorId(@PathVariable long id) {
        UserBD userFound = service.getUserById(id);

        if(userFound != null) {
            return ResponseEntity.ok(userFound);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
