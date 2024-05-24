package com.shd.newSchoolManagement.service.mapper;

import com.shd.newSchoolManagement.domain.Student;
import com.shd.newSchoolManagement.domain.Subject;
import com.shd.newSchoolManagement.service.dto.StudentDTO;
import com.shd.newSchoolManagement.service.dto.SubjectDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SubMapper extends EntityMapper<SubjectDTO, Subject> {
}

