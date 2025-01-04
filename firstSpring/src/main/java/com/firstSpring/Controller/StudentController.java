package com.firstSpring.Controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.firstSpring.Entity.Student;
import com.firstSpring.Exceptions.ResourceNotFoundException;
import com.firstSpring.Repository.StudentRepo;
import com.firstSpring.Service.StudentService;

@RestController
public class StudentController {
    
    @Autowired
    StudentRepo studentRepo;

    @Autowired
    StudentService studentService;

    @PostMapping("create")
    public Student createStudent(@RequestBody Student object) {
               
        return studentRepo.save(object);
    }

    
    @PostMapping("createall")
    public List<Student> createAllStudent(@RequestBody List<Student> object) {
               
        return studentRepo.saveAll(object);
    }

    @GetMapping("displaystudent")
       
    public List<Student> getAllStudent()
    {
        List<Student> std= studentRepo.findAll(); 
        return std.stream().sorted((o1,o2)->o1.getName().compareTo(o2.getName())).collect(Collectors.toList());

    }

     @GetMapping("/displayall/{page}/{size}")
    public Page<Student> getAll(@PathVariable int page,
                                @PathVariable int size
                                ) {
                                Pageable pageable = Pageable.ofSize(size).withPage(page);
                                return studentRepo.findAll(pageable);
    }


    @GetMapping("displayById/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable int id) {
        return ResponseEntity.ok(studentRepo.findById(id)
        .orElseThrow(()->new ResourceNotFoundException(id, "Student")));
    }

    @GetMapping("getstudent")
    public List<Student> getStudent()
    {
        return studentService.getStudent();
    }

    public String getMethodName(@RequestParam String param) {
        return new String();
    }
    
    
    @DeleteMapping("delete/{id}")
    public String deleteById(@PathVariable int id)    
    {
        studentRepo.deleteById(id);
        return "Record deleted successfully";
    }

    @PutMapping("update/{id}")
    public Student updateStudent(@PathVariable int id, @RequestBody Student student) {
        //TODO: process PUT request
        
        Student std= studentRepo.findById(id).get();
        std.setName(student.getName());
        std.setPlace(student.getPlace());
        studentRepo.save(std);
        return std;
    }


}



// Update   @PutMapping
