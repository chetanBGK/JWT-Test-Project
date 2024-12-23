package com.firstSpring.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.firstSpring.Entity.Student;

public interface StudentRepo extends JpaRepository<Student, Integer>{
    
}
