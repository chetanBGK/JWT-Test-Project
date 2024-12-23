package com.firstSpring.Security;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.firstSpring.Entity.User;
import com.firstSpring.Repository.UserRepo;

@Service
public class UserPassService {
    
    // @Autowired
    private final UserRepo userRepo;
    // @Autowired
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public UserPassService(UserRepo userRepo, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepo = userRepo;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    public User createUser(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        return userRepo.save(user);
    }
}
