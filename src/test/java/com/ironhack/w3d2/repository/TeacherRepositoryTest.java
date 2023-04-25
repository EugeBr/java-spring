package com.ironhack.w3d2.repository;

import com.ironhack.w3d2.model.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TeacherRepositoryTest {

//* generates an object that can use the db data // enables automatic dependency injection
    @Autowired
    TeacherRepository teacherRepository;

    @Test
    public void findAll_teachers_teachersList() {
        List<Teacher> teacherList = teacherRepository.findAll(); //returns a list of all teachers from db
        //System.out.println(teacherList);
        assertEquals(3, teacherList.size());
    }

    @Test
    public void findById_validId_correctTeacher() {
        Optional<Teacher> teacher = teacherRepository.findById(1); //* Optional data type is used to prevent null data
        //Teacher teacher = teacherRepository.findById(1);        // Incorrect
        assertTrue(teacher.isPresent());
        //System.out.println(teacher.get());
        assertEquals("Alberto García", teacher.get().getTeacher());
    }

    @Test
    public void findById_invalidId_teacherNotPresent() {
        Optional<Teacher> teacher = teacherRepository.findById(999);
        assertFalse(teacher.isPresent());
        //assertTrue(teacher.isEmpty());        // same thing
    }

}