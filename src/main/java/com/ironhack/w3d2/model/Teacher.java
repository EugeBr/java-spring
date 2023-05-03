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

    @OneToOne(cascade = CascadeType.ALL)               //* establish one-to-one relationship
    @JoinColumn(name = "address_id")
    private Address address;

//    @OneToMany(mappedBy = "teacher")      // bidirectional relationship (triggers infinite loop)
//    @ToString.Exclude
//    private List<Course> courses;

//  !! IMPORTANT        //  Spring NEEDS an empty constructor
    public Teacher() {
    }

    public Teacher(String teacher, Address address) {
        this.teacher = teacher;
        this.address = address;
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

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

//  not mandatory, but useful for testing
    @Override
    public String toString() {
        return "Teacher{" +
                "id=" + id +
                ", teacher='" + teacher + '\'' +
                ", address=" + address +
                '}';
    }
}
