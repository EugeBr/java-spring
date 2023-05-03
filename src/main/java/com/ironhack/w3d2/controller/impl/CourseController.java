package com.ironhack.w3d2.controller.impl;

import com.ironhack.w3d2.controller.dto.CourseClassroomDTO;
import com.ironhack.w3d2.controller.dto.CourseHoursDTO;
import com.ironhack.w3d2.controller.interfaces.ICourseController;
import com.ironhack.w3d2.model.Course;
import com.ironhack.w3d2.repository.CourseRepository;
import com.ironhack.w3d2.service.interfaces.ICourseService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class CourseController implements ICourseController {

    @Autowired
    CourseRepository courseRepository;

    @Autowired
    ICourseService courseService;   //* to get all methods from service

//  *********************************************** GET **********************************************************

    @GetMapping("/courses")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public List<Course> getAllCourses(){
        return courseRepository.findAll();
    }

    @GetMapping("/courses/{course}")
    public Course getCourseById(@PathVariable(name = "course") String course) {     //* @PathVariable(name = "course") if the names are different
        return courseService.getCourseById(course);
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
        return courseService.getCourseByClassroomAndHours(classroom, hours);
    }

//  *********************************************** POST **********************************************************

    @PostMapping("/courses")
    @ResponseStatus(HttpStatus.CREATED)
    public void saveCourse(@RequestBody @Valid Course course) {
        courseService.saveCourse(course);
    }

//  *********************************************** PUT ************************************************************
//* to change whole object for a new object

    @PutMapping("/courses/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateCourse(@RequestBody @Valid Course course, @PathVariable String id) {
        courseService.updateCourse(course, id);
    }

//  *********************************************** PATCH **********************************************************
//* to change only one field

    @PatchMapping("/courses/hours/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateCourseHours(@RequestBody @Valid CourseHoursDTO courseHoursDTO, @PathVariable String id) {
        courseService.updateCourseHours(courseHoursDTO.getHours(), id);
    }

    @PatchMapping("/courses/classroom/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateCourseClassroom(@RequestBody @Valid CourseClassroomDTO courseClassroomDTO, @PathVariable String id) {
        courseService.updateCourseClassroom(courseClassroomDTO.getClassroom(), id);
    }
//  *********************************************** DELETE *********************************************************

    @DeleteMapping("/courses/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCourse(@PathVariable String id) {
        courseService.deleteCourse(id);
    }
}
