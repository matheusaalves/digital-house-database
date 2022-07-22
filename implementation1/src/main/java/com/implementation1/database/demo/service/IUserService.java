package com.implementation1.database.demo.service;

import com.implementation1.database.demo.model.UserBD;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface IUserService {
    UserBD getUserById(long id);
    UserBD insertUser(UserBD newUser);
    UserBD update(UserBD user);
    UserBD updatePartial(long id, Map<String, String> changes);
    void deleteUser(long id);
    List<UserBD> listAll();
    UserBD findByEmail(String email);
}
