package com.ironhack.w3d2.service.interfaces;
import com.ironhack.w3d2.model.Course;
import java.util.List;
import java.util.Optional;

//* this interface is mandatory

public interface ICourseService {

    Course getCourseById(String course);
    List<Course> getCourseByClassroomAndHours( String classroom, Optional<Integer> hours);
    void updateCourse(Course course, String id);
    void updateCourseHours(Integer hours, String id);
    void updateCourseClassroom(String classroom, String id);
    void deleteCourse(String id);
}
