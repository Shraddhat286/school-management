package com.shd.newSchoolManagement.service.mapper;

import com.shd.newSchoolManagement.domain.Student;
import com.shd.newSchoolManagement.service.dto.StudentDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface StudentMapper extends EntityMapper<StudentDTO, Student> {
}
