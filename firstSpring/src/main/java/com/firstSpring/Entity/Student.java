package com.firstSpring.Entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int rollNo;

    @Column(name="Student_Name", nullable=false,length=20)
    private String name;
    private String place;

    @OneToMany

    private List<Subject> subjects=new ArrayList<>();

       @Override
    public String toString() {
        return "Student [rollNo=" + rollNo + ", name=" + name + ", place=" + place + "]";
    } 

    


}
