package com.firstSpring.Controller;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.firstSpring.Entity.User;
import com.firstSpring.Repository.UserRepo;
import com.firstSpring.Security.UserPassService;
import com.firstSpring.Service.UserService;



@RestController
public class UserController {
    
    UserService userService;

    @Autowired
    UserRepo userRepo;

    @Autowired
    UserPassService userPassService;
    

    //     public UserRepo getUserRepo() {
    //     return userRepo;
    // }

    public UserController(UserService userService) {
        this.userService = userService;
    }

    // public UserController(UserPassService userPassService) {
    //     this.userPassService = userPassService;
    // }

    @PostMapping("adduser")
    public User addUser(@RequestBody User user) {
        // return userService.createUser(user);
        return userPassService.createUser(user);
               
    }

    @GetMapping("getallusers")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("getuserbyid")
    public User getUserById(@RequestParam int id) {
        return userService.getUserById(id);
    }

    @PutMapping("updateuser/{id}")
    public User updateUser(@PathVariable int id, @RequestBody User user) {
    return userService.updateUser(id, user);
    }

    @DeleteMapping("deleteuser/{id}")
    public void deleteUser(@PathVariable int id) {
        userService.deleteUser(id);
    }

    @PostMapping("login")
    public String loginForm(@RequestBody User user) {
        
//        User user1 = userRepo.findByUserName(user.getUserName());
//
//        if(Objects.isNull(user1)) {
//            return "User not found";
//        }
//        return "Success";

        return userPassService.verifyUser(user);
    }
    


    
    
    
}
