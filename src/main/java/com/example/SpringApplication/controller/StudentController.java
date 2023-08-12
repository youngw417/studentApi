package com.example.SpringApplication.controller;

import com.example.SpringApplication.dto.StudentSaveDTO;
import com.example.SpringApplication.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("api/v1/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping (path="/save")
    public String saveStudent(@RequestBody StudentSaveDTO studentSaveDTO) {

        String id = studentService.addStudent(studentSaveDTO);
        return id;
    }

    @GetMapping(path="/getrecords")
    public String getFat() {
        return "I am from Korea";
    }
}
