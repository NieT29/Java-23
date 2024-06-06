package com.example.demo.model;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Builder
@ToString
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@Component
public class Classroom {
    //C1: Field based Injection
//    @Autowired
//    Student student;
//
//    @Autowired
//    Teacher teacher;

    //C2: Contructor based Injection
    Student student;


    Teacher teacher;

    public Classroom(Student student, @Qualifier("teacher") Teacher teacher) {
        System.out.println("Classroom");
        System.out.println("Student" + student);
        System.out.println("Teacher" + teacher);

        this.student = student;
        this.teacher = teacher;
    }
}
