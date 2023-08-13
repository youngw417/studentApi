package com.example.SpringApplication.controller;

import com.example.SpringApplication.dto.StudentDTO;
import com.example.SpringApplication.dto.StudentSaveDTO;
import com.example.SpringApplication.dto.StudentUpdateDTO;
import com.example.SpringApplication.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping(path="/getallstudents")
    public List<StudentDTO> getAll() {
        List<StudentDTO> studentList = studentService.getall();
        return studentList;
    }

    @PutMapping(path="/update/{id}")
    public String update(@PathVariable int id, @RequestBody StudentUpdateDTO studentUpdateDTO) {
        String response = studentService.update(id, studentUpdateDTO);
        return response;
    }

    @DeleteMapping(path="/delete/{id}")
    public boolean delete(@PathVariable(value = "id") int id) {
        boolean deleted = studentService.delete(id);
        return deleted;
    }

    @GetMapping(path="/get-by-id", params = "id")
    public StudentDTO getStudent(@RequestParam(value="id") int id) {
        StudentDTO student = studentService.getStudent(id);
        return student;
    }
}
