package com.example.SpringApplication.service;

import com.example.SpringApplication.dto.StudentDTO;
import com.example.SpringApplication.dto.StudentSaveDTO;
import com.example.SpringApplication.dto.StudentUpdateDTO;

import java.util.List;

public interface StudentService {
    String addStudent(StudentSaveDTO studentSaveDTO);

    List<StudentDTO> getall();

    String update(int id, StudentUpdateDTO studentUpdateDTO);

    boolean delete(int id);
}
