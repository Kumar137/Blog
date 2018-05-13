package com.upgrad.ImageHoster.service;

import com.upgrad.ImageHoster.model.User;

public interface UserService {

    public boolean authenticate(String username,String password);
    public boolean registerNewUser(User user);

}
