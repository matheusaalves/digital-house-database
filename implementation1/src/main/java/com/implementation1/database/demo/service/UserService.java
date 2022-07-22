package com.implementation1.database.demo.service;

import com.implementation1.database.demo.model.UserBD;
import com.implementation1.database.demo.repository.IUserDbRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private IUserDbRepo userRepo;

    public UserBD getUserById(long id) {
//        return (UserBD) userRepo.findById(id).get();
        return (UserBD) userRepo.findById(id).orElse(null);
    }
}
