package com.ironhack.w3d2.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Course {
    @Id
    private String course;
    private Integer hours;
    private String classroom;
    private String vacations;

//  @Column(name = "teacher_id")    // not necessary (snake_case translates to camelCase)
    private Integer teacherId;

//! necessary for spring
    public Course() {
    }

//* not necessary, but we need it if we want to create objects manually
    public Course(String course, Integer hours, String classroom, String vacations, Integer teacherId) {
        this.course = course;
        this.hours = hours;
        this.classroom = classroom;
        this.vacations = vacations;
        this.teacherId = teacherId;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public Integer getHours() {
        return hours;
    }

    public void setHours(Integer hours) {
        this.hours = hours;
    }

    public String getClassroom() {
        return classroom;
    }

    public void setClassroom(String classroom) {
        this.classroom = classroom;
    }

    public String getVacations() {
        return vacations;
    }

    public void setVacations(String vacations) {
        this.vacations = vacations;
    }

    public Integer getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Integer teacherId) {
        this.teacherId = teacherId;
    }
}
