package com.implementation1.database.demo.service;

import com.implementation1.database.demo.model.UserBD;

import java.util.Optional;

public interface IUserService {
    Optional<UserBD> getUserById(long id);
    UserBD insertUser(UserBD newUser);
    void deleteUser(long id);
}
