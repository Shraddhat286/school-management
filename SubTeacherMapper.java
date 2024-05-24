package com.shd.newSchoolManagement.service.mapper;

import com.shd.newSchoolManagement.domain.SubTeacher;
import com.shd.newSchoolManagement.service.dto.SubTeacherDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SubTeacherMapper extends EntityMapper<SubTeacherDTO,SubTeacher> {

}
