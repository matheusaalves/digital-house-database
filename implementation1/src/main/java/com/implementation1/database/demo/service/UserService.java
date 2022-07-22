package com.implementation1.database.demo.service;

import com.implementation1.database.demo.exception.BadRequestException;
import com.implementation1.database.demo.exception.UserNotFoundException;
import com.implementation1.database.demo.model.UserBD;
import com.implementation1.database.demo.repository.IUserDbRepo;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class UserService implements IUserService {

    @Autowired
    private IUserDbRepo userRepo;

    @Override
    public UserBD getUserById(long id) {
        return userRepo.findById(id)
                .orElseThrow(() -> new UserNotFoundException("Usuário não encontrado, id: " + id));
//        return userRepo.findById(id);
//        return (UserBD) userRepo.findById(id).orElse(null);
    }

    @Override
    public UserBD insertUser(UserBD newUser) {
        if(newUser.getId() > 0) {
            throw new BadRequestException("O usuário não pode ter Id para ser inseridos");
        }
        UserBD user = userRepo.save(newUser);
        return userRepo.save(newUser);
    }

    @Override
    public UserBD update(UserBD user) {
        UserBD userFound = getUserById(user.getId());
        return userRepo.save(user);
    }

    @Override
    public UserBD updatePartial(long id, Map<String, String> changes) {
        UserBD userFound = getUserById(id);


        Class<?> c = userFound.getClass();
        changes.forEach((attribute, value) -> {
            String attr = attribute.substring(0,1).toUpperCase() + attribute.substring(1).toLowerCase();
            try {
//                Method method = null;
//                method = c.getDeclaredMethod("set" + attr, value.getClass());
//                method.invoke(userFound, value);

                c.getDeclaredMethod("set" + attr, value.getClass()).invoke(userFound, value);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });


//        changes.forEach((attribute, value) -> {
//            switch (attribute) {
//                case "name": userFound.setName(value);
//                case "email": userFound.setEmail(value);
//            }
//        });

        return userRepo.save(userFound);
    }


    @Override
    public void deleteUser(long id) {
        getUserById(id);
        userRepo.deleteById(id);
    }

    public List<UserBD> listAll() {
        return (List<UserBD>) userRepo.findAll();
    }

    @Override
    public UserBD findByEmail(String email) {
        return userRepo.findByEmail(email);
    }

}
