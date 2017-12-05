package com.jj.service;

import com.jj.entity.User;

public interface UserService {
    public User findUserByEmail(String email);
    public void saveUser(User user);
}
