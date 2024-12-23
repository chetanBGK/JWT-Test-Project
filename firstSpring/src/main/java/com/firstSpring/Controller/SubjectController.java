package com.firstSpring.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.firstSpring.Entity.Subject;
import com.firstSpring.Service.SubjectService;




@RestController
public class SubjectController {
    
    @Autowired
    SubjectService subjectService;

    @PostMapping("addsubject/{id}")
    public Subject addSubject(@RequestBody Subject subject,@PathVariable int id) {
                
        return subjectService.createSubject(subject,id);
    }
    
    @GetMapping("displaysubject")
    public List<Subject> getAllSubject() {
        return subjectService.getSubject();
    }
    
    @GetMapping("displysubbyid/{id}")
    public Subject getSubjectByid(@PathVariable int id) {
        return subjectService.getSubjectbyId(id);
    }
    
    @PutMapping("updatesub/{id}")
    public Subject updateSubject(@RequestBody Subject subejct,@PathVariable int id) {
                
        return subjectService.updateSubject(subejct, id);
    }

    @DeleteMapping("deletesubject/{id}")
    public void deletesubject(@PathVariable int id)
    {
        subjectService.deleteSubject(id);
    }
    
    
}
