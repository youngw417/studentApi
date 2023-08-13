package com.example.SpringApplication.service;

import com.example.SpringApplication.dto.StudentDTO;
import com.example.SpringApplication.dto.StudentSaveDTO;
import com.example.SpringApplication.dto.StudentUpdateDTO;
import com.example.SpringApplication.entity.Student;
import com.example.SpringApplication.repo.StudentRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService{

    private StudentRepo studentRepo;
    private ModelMapper modelMapper;

    @Autowired
    public StudentServiceImpl(StudentRepo studentRepo, ModelMapper modelMapper) {
        this.studentRepo = studentRepo;
        this.modelMapper = modelMapper;
    }

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

    @Override
    public List<StudentDTO> getall() {

        List<Student> students = studentRepo.findAll();
        List<StudentDTO> studentDTOS = new ArrayList<>();
        for (Student student : students) {
            StudentDTO studentDTO = new StudentDTO(
                    student.getStudentId(),
                    student.getStudentName(),
                    student.getAddress(),
                    student.getMobile(),
                    student.isActiveState()
            );
            studentDTOS.add(studentDTO);
        }
        return studentDTOS;
    }

    @Override
    public String update(int id, StudentUpdateDTO studentUpdateDTO) {
        if (studentRepo.existsById(id)) {
            Student student = new Student();
            student.setStudentId(id);
            student.setStudentName(studentUpdateDTO.getStudentName());
            student.setAddress(studentUpdateDTO.getAddress());
            student.setMobile(studentUpdateDTO.getMobile());
            student.setActiveState(studentUpdateDTO.isActiveState());
            studentRepo.save(student);
        } else  {

            return " NO ID is found";
        }
        return studentUpdateDTO.getStudentName() + " is updated";
    }

    @Override
    public boolean delete(int id) {

        if (studentRepo.existsById(id)) {
            studentRepo.deleteById(id);
            return true;
        } else
            return false;
    }

    @Override
    public StudentDTO getStudent(int id) {
        Optional<Student> optional = studentRepo.findById(id);
        if (optional.isPresent()) {
            Student student = optional.get();
            StudentDTO studentDTO = modelMapper.map(student, StudentDTO.class);

            return studentDTO;
        } else {
            System.out.println("No student by the id: " + id);
        }
        return null;
    }


}
