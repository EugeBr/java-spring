package com.ironhack.w3d2.controller.interfaces;

import com.ironhack.w3d2.model.Course;
import java.util.List;
import java.util.Optional;

//* OPTIONAL but useful when there are a lot of routes
public interface ICourseController {
    List<Course> getAllCourses();
    Course getCourseById(String course);
    List<Course> getCourseByHoursLessThan(Integer hours);
    List<Course> getCourseByClassroomAndHours( String classroom, Optional<Integer> hours);
}
