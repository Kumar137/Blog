package com.upgrad.ImageHoster.service;

import com.upgrad.ImageHoster.model.User;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImp implements UserService {
    @Override
    public boolean authenticate(String username, String password) {
       return true;
    }

    @Override
    public boolean registerNewUser(User user) {
        return false;
    }
}
