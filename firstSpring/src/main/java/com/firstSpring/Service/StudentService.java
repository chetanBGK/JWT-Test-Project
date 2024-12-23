package com.firstSpring.Service;

import java.util.List;

import com.firstSpring.Entity.Student;

public interface StudentService {

    Student cretaStudent(Student student);
    List<Student> getStudent();
    Student getStudentbyid(int id);
    Student updateStudent(Student student, int id);
    void deleteStudent(int id);
   
}
