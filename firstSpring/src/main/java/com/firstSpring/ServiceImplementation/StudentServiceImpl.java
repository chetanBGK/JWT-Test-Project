package com.firstSpring.ServiceImplementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.firstSpring.Entity.Student;
import com.firstSpring.Repository.StudentRepo;
import com.firstSpring.Service.StudentService;

@Service
public class StudentServiceImpl implements  StudentService{

    @Autowired
    StudentRepo studentRepo;



    @Override
    public Student cretaStudent(Student student) {
        if(student.getName()== null)
        {
            // throw 
        }

        return  studentRepo.save(student);
    }

  
    @Override
    public Student updateStudent(Student student,int id) {
        Student students=studentRepo.findById(id).get();
        students.setName(student.getName());
        students.setPlace(student.getPlace());
        return  students;
    }

    @Override
    public void deleteStudent(int id) {
        studentRepo.deleteById(id);
    }


    @Override
    public List<Student> getStudent() {
        return studentRepo.findAll();
    }


    @Override
    public Student getStudentbyid(int id) {
        return  studentRepo.findById(id).get();
        //  orElseThrow(()->new ResourceNotFoundException(id, "Student"));
    }
    
}
