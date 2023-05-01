package com.ironhack.w3d2.controller.impl;

import com.ironhack.w3d2.model.Course;
import com.ironhack.w3d2.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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

    @GetMapping("/courses/{course}")
    public Course getCourseById(@PathVariable(name = "course") String course) {     //* @PathVariable(name = "course") if the names are different
        Optional<Course> courseOptional = courseRepository.findById(course);
        if(courseOptional.isEmpty()) return null;
        return courseOptional.get();
    }

//      QUERY PARAMS PETITION
//      http://localhost:8080/api/courses/hours?hours=150
    @GetMapping("/courses/hours")
    public List<Course> getCourseByHoursLessThan(@RequestParam(defaultValue = "100") Integer hours) {
        return courseRepository.findAllByHoursLessThan(hours);
    }

//    http://localhost:8080/api/courses/classroom?classroom=B1&hours=150
    @GetMapping("/courses/classroom")
    public List<Course> getCourseByClassroomAndHours(
            @RequestParam(defaultValue = "A1") String classroom,
            @RequestParam Optional<Integer> hours       //* if I want only one mandatory param
    ) {
        if (hours.isPresent()) return courseRepository.findAllByClassroomAndHours(classroom, hours.get());
        return courseRepository.findAllByClassroom(classroom);
    }

}
