package com.ironhack.w3d2.controller.interfaces;

import com.ironhack.w3d2.model.Course;
import java.util.List;
import java.util.Optional;

//* OPTIONAL but useful when there are a lot of routes
//* for example: if we accidentally erase a method in the controller

public interface ICourseController {
    List<Course> getAllCourses();
    Course getCourseById(String course);
    List<Course> getCourseByHoursLessThan(Integer hours);
    List<Course> getCourseByClassroomAndHours( String classroom, Optional<Integer> hours);

    void saveCourse(Course course);
    void updateCourse(Course course, String id);
    void updateCourseHours(Integer hours, String id);
    void updateCourseClassroom(String classroom, String id);
    void deleteCourse(String id);
}
