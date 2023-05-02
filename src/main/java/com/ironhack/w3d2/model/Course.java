package com.ironhack.w3d2.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;

@Entity
public class Course {
    @Id
    private String course;
    @Max(value = 400, message = "The course can't be longer than 400 hour")
    @Min(50)
    private Integer hours;
    @NotEmpty(message = "Classroom can't be empty")
    private String classroom;
    private String vacations;

    @ManyToOne                          //* because many courses could be given by one teacher
    @JoinColumn(name = "teacher_id")    //* reference from db
    private Teacher teacher;

//! necessary for spring
    public Course() {
    }

//* not necessary, but we need it if we want to create objects manually
    public Course(String course, Integer hours, String classroom, String vacations, Teacher teacher) {
        this.course = course;
        this.hours = hours;
        this.classroom = classroom;
        this.vacations = vacations;
        this.teacher = teacher;
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

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    @Override
    public String toString() {
        return "Course{" +
                "course='" + course + '\'' +
                ", hours=" + hours +
                ", classroom='" + classroom + '\'' +
                ", vacations='" + vacations + '\'' +
                ", teacher=" + teacher +
                '}';
    }
}
