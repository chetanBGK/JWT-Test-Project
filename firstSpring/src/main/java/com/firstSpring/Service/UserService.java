package com.firstSpring.Service;

import java.util.List;

import com.firstSpring.Entity.User;

public interface UserService {
    User createUser(User user);
    User getUserById(int id);
    List<User> getAllUsers();
    User updateUser(int id, User user);
    void deleteUser(int id);
}
