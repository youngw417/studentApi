package com.example.SpringApplication.entity;


import javax.persistence.*;


@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "student_id", length = 50)
    private int studentId;
    @Column(name = "student_name", length = 50)
    private String studentName;
    @Column(name = "address", length = 70)
    private String address;
    @Column (name = "mobile", length = 12)
    private String mobile;
    @Column(name = "active_state", columnDefinition = "TINYINT default 1")
    private boolean activeState;

    public Student(int studentId, String studentName, String address, String mobile, boolean activeState) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.address = address;
        this.mobile = mobile;
        this.activeState = activeState;
    }

    public Student(String studentName, String address, String mobile, boolean activeState) {
        this.studentName = studentName;
        this.address = address;
        this.mobile = mobile;
        this.activeState = activeState;
    }

    public Student() {
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public boolean isActiveState() {
        return activeState;
    }

    public void setActiveState(boolean activeState) {
        this.activeState = activeState;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentId=" + studentId +
                ", studentName='" + studentName + '\'' +
                ", address='" + address + '\'' +
                ", mobile='" + mobile + '\'' +
                ", activeState=" + activeState +
                '}';
    }
}
