package com.firstSpring.ServiceImplementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.firstSpring.Entity.Student;
import com.firstSpring.Entity.Subject;
import com.firstSpring.Repository.StudentRepo;
import com.firstSpring.Repository.SubjectRepo;
import com.firstSpring.Service.SubjectService;

@Service
public class SubjectServiceImpl implements  SubjectService {

    @Autowired
    SubjectRepo subjectRepo;

    @Autowired
    StudentRepo studentRepo;

    @Override
    public Subject createSubject(Subject subject,int studentId) {
        Student students= studentRepo.findById(studentId).get();
        subject.setStudent(students);
        return subjectRepo.save(subject);
    }
    
    @Override
    public List<Subject> getSubject() {
        return subjectRepo.findAll();
    }

    @Override
    public Subject getSubjectbyId(int id) {
        return subjectRepo.findById(id).get();
    }

    @Override
    public Subject updateSubject(Subject subject, int id) {
        Subject subjects=subjectRepo.findById(id).get();
        subjects.setSubjectName(subject.getSubjectName());
        subjectRepo.save(subjects);
        return subjects;
    }

    @Override
    public void deleteSubject(int id) {
        subjectRepo.deleteById(id);
    }
    

}
