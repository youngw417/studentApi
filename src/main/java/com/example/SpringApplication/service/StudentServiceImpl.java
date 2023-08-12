package com.example.SpringApplication.service;

import com.example.SpringApplication.dto.StudentSaveDTO;
import com.example.SpringApplication.entity.Student;
import com.example.SpringApplication.repo.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService{

    @Autowired
    private StudentRepo studentRepo;

    @Override
    public String addStudent(StudentSaveDTO studentSaveDTO) {

        Student student = new Student(
                studentSaveDTO.getStudentName(),
                studentSaveDTO.getAddress(),
                studentSaveDTO.getMobile(),
                studentSaveDTO.isActiveState()
        );
        studentRepo.save(student);
        return student.getStudentName();
    }
}
