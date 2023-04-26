package com.ironhack.w3d2.model;

import jakarta.persistence.*;

@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer grade;
    @Embedded       //* to allow sql to interpret StudentInfo
    private StudentInfo studentInfo;

    public Student() {
    }

    public Student(Integer id, Integer grade, StudentInfo studentInfo) {
        this.id = id;
        this.grade = grade;
        this.studentInfo = studentInfo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    public StudentInfo getStudentInfo() {
        return studentInfo;
    }

    public void setStudentInfo(StudentInfo studentInfo) {
        this.studentInfo = studentInfo;
    }
}
