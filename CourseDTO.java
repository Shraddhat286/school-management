package com.shd.newSchoolManagement.service.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CourseDTO {
    private Long id;

    private String name;

    private String type;

    private StudentDTO student;

    private SubTeacherDTO subTeacher;

}

