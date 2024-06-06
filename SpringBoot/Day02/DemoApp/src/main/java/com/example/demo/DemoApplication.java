package com.example.demo;

import com.example.demo.model.Student;
import com.example.demo.model.Teacher;
import com.fasterxml.jackson.core.JsonPointer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

// @Bean phải được định nghĩa trong class được chú thích bởi @Configuration
@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(DemoApplication.class, args);

        Student student = context.getBean(Student.class);
        System.out.println(student);

        Teacher teacher = context.getBean("teacher2", Teacher.class);
        System.out.println(teacher);
    }

    @Bean
    public Student student() {
        return new Student(1, "nguyễn văn a");
    }

    @Bean(name = "teacher1")
    public Teacher teacher() {
        return new Teacher(1, "Nguyễn thị b");
    }

    @Bean(name = "teacher2")
    public Teacher teacher1() {
        return new Teacher(2, "Nguyễn thị c");
    }
}
