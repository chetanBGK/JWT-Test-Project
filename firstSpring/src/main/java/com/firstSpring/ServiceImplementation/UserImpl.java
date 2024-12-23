package com.firstSpring.ServiceImplementation;

import java.util.List;

import org.springframework.stereotype.Service;

import com.firstSpring.Entity.User;
import com.firstSpring.Repository.UserRepo;
import com.firstSpring.Service.UserService;

@Service
public class UserImpl implements UserService{

    UserRepo userRepo;

    public UserImpl(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public User createUser(User user) {
       return userRepo.save(user);
    }

    @Override
    public User getUserById(int id) {
        return userRepo.findById(id).get();
    }

    @Override
    public List<User> getAllUsers() {
        return userRepo.findAll();
    }

    @Override
    public User updateUser(int id, User user) {

        User user1 = userRepo.findById(id).get();

        user1.setUserName(user.getUserName());
        user1.setPassword(user.getPassword());

        return userRepo.save(user1);
        
    }

    @Override
    public void deleteUser(int id) {
      userRepo.deleteById(id);
    }
    
}
