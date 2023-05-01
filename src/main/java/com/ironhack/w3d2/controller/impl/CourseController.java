package com.ironhack.w3d2.controller.impl;

import com.ironhack.w3d2.model.Course;
import com.ironhack.w3d2.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CourseController {

    @Autowired
    CourseRepository courseRepository;

    @GetMapping("/courses")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public List<Course> getAllCourses(){
        return courseRepository.findAll();
    }

}
