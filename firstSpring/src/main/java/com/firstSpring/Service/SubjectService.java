package com.firstSpring.Service;

import java.util.List;

import com.firstSpring.Entity.Subject;

public interface SubjectService {
    Subject createSubject(Subject subject,int studentId);
    List<Subject> getSubject();
    Subject getSubjectbyId(int id);
    Subject updateSubject(Subject subject,int id);
    void deleteSubject(int id);
}
