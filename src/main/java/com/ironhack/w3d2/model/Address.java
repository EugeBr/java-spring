package com.ironhack.w3d2.model;

import jakarta.persistence.*;

@Entity
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String street;
    private String houseCode;

//    ! Not recommended, could trigger infinite loop
//    @OneToOne(mappedBy = "address")
//    private Teacher teacher;

    public Address() {
    }

    public Address(String street, String houseCode) {
        this.street = street;
        this.houseCode = houseCode;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getHouseCode() {
        return houseCode;
    }

    public void setHouseCode(String houseCode) {
        this.houseCode = houseCode;
    }
}
