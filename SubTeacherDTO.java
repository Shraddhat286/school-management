package com.shd.newSchoolManagement.service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SubTeacherDTO {

    private Long id;

    private String name;

    private double  salary;

    private Long experience;

}
