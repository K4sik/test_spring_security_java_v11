package com.kas.test_spring_security_java_v11.controller;

import com.kas.test_spring_security_java_v11.student.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("api/v1/students")
public class StudentController {

    private static final List<Student> STUDENTS = Arrays.asList(
            new Student((long) 1, "Joe"),
            new Student((long) 2, "Sophi"),
            new Student((long) 3, "Anna")
    );

    @GetMapping(path = "{studentId}")
    public Student getStudent(@PathVariable("studentId") Long studentId){
        return STUDENTS.stream().filter(student -> studentId.equals(student.getStudentId()))
                .findFirst()
                .orElseThrow(() -> new IllegalStateException("Student " + studentId + " does not exists"));
    }

}
