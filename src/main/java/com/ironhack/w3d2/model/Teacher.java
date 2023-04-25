package com.ironhack.w3d2.model;

import jakarta.persistence.*;

@Entity                      //* entities 'transform' sql tables to java classes
//@Table(name="teacher")     // only if the name of table is different in sql script
public class Teacher {
    @Id                     //* to assign primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "id")    //only if the name of property is different in sql script
    private Integer id;       //! cant be primitive type

//    @Column(name = "teacher")
    private String teacher;

//  !! IMPORTANT
//  Spring NEEDS an empty constructor
    public Teacher() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    //not mandatory, just useful for testing
    @Override
    public String toString() {
        return "Teacher{" +
                "id=" + id +
                ", teacher='" + teacher + '\'' +
                '}';
    }
}
