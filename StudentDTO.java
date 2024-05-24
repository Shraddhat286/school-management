package com.shd.newSchoolManagement.service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentDTO {
    private Long id;

    private String name;

    private Long age;

    private DivisionDTO division;

}
