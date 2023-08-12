package com.example.SpringApplication.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class StudentSaveDTO {

    private int studentId;

    private String studentName;

    private String address;

    private String mobile;

    private boolean activeState;
}
