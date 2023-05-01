package com.ironhack.w3d2.controller.interfaces;

import com.ironhack.w3d2.model.Teacher;

import java.util.List;
//* OPTIONAL but useful when there are a lot of routes
public interface ITeacherController {
    List<Teacher> getAllTeachers();
    Teacher getTeacherById(Integer id);
}
