package com.implementation1.database.demo.service;

import com.implementation1.database.demo.model.UserBD;
import com.implementation1.database.demo.repository.IUserDbRepo;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService implements IUserService {

    @Autowired
    private IUserDbRepo userRepo;

    @Override
    public Optional<UserBD> getUserById(long id) {
        return userRepo.findById(id);
//        return (UserBD) userRepo.findById(id).orElse(null);
    }

    @Override
    public UserBD insertUser(UserBD newUser) {
        if(newUser.getId() > 0) return null;
        UserBD user = userRepo.save(newUser);
        return userRepo.save(newUser);
    }

    @Override
    public void deleteUser(long id) {
        if(userRepo.findById(id).isPresent()) {
            userRepo.deleteById(id);
        }
        // TODO: Lançar exceção
    }


}
