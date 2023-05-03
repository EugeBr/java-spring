package com.ironhack.w3d2.controller.dto;

import jakarta.validation.constraints.NotEmpty;

public class CourseClassroomDTO {

    @NotEmpty(message = "Classroom can't be empty")
    private String classroom;

    public CourseClassroomDTO() {
    }

    public CourseClassroomDTO(String classroom) {
        this.classroom = classroom;
    }

    public String getClassroom() {
        return classroom;
    }
}
