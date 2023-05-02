package com.ironhack.w3d2.controller.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;

//* the purpose of this class is to be able to update one value (hours) in PATCH route
public class CourseHoursDTO {

    @Max(value = 400, message = "The course can't be longer than 400 hour")
    @Min(50)
    private Integer hours;

    public Integer getHours() {
        return hours;
    }
}
