package com.firstSpring.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.firstSpring.Entity.Subject;

public interface SubjectRepo extends  JpaRepository<Subject, Integer>{
    
}
