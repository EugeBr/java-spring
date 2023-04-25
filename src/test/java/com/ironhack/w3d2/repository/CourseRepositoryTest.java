package com.ironhack.w3d2.repository;

import com.ironhack.w3d2.model.Course;
import com.ironhack.w3d2.model.Teacher;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CourseRepositoryTest {

    @Autowired
    CourseRepository courseRepository;

//*    examples
//    @BeforeEach
//    public void setUp() {
//        Course algebra = new Course("Algebra", 150, "B1", "2 weeks", 1);
//        courseRepository.save(algebra);  //* new course added
//    }
//
//    @AfterEach
//    public void tearDown() {
//        courseRepository.deleteById("Algebra");
//    }

    @Test
    public void findAll_courses_courseList() {
        List<Course> courseList = courseRepository.findAll();
        assertEquals(6, courseList.size());
    }

    @Test
    public void findById_validId_correctCourse() {
        Optional<Course> course = courseRepository.findById("Math");
        assertTrue(course.isPresent());
        assertEquals(100, course.get().getHours());
    }

    @Test
    public void findById_invalidId_courseNotPresent() {
        Optional<Course> course = courseRepository.findById("Politics");
        assertFalse(course.isPresent());
    }

    @Test
    public void findByHours_validHours_correctCourse() {
        Optional<Course> course = courseRepository.findByHours(90);
        assertTrue(course.isPresent());
        assertEquals("English", course.get().getCourse());
    }

    @Test
    public void findAllByClassroom_validClassroom_courseList() {
        List<Course> courseList = courseRepository.findAllByClassroom("B1");
        assertEquals(2, courseList.size());
    }
}