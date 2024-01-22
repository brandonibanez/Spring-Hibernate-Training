package com.luv2code.RestDemo.rest;

import com.luv2code.RestDemo.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    private List<Student> list;

    @PostConstruct
    public void loadData() {
        list = new ArrayList<>(
                List.of(
                        new Student("qwe", "qwe"),
                        new Student("asd", "asd"),
                        new Student("zxc", "zxc"))
        );
    }

    @GetMapping("/students")
    public List<Student> getStudents() {
        return list;
    }

    @GetMapping("/students/{id}")
    public Student getStudentWithId(@PathVariable int id) {

        if(id >= list.size()  || id < 0) {
            throw new StudentNotFoundException("Student id not found: " + id);
        }

        return list.get(id);
    }

}
