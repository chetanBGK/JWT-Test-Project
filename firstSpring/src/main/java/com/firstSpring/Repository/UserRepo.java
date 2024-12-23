package com.firstSpring.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.firstSpring.Entity.User;

public interface UserRepo extends  JpaRepository<User, Integer>{
    User findByUserName(String userName) ;
}
