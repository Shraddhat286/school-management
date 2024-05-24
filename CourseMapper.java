package com.shd.newSchoolManagement.service.mapper;

import com.shd.newSchoolManagement.domain.Course;
import com.shd.newSchoolManagement.service.dto.CourseDTO;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface CourseMapper extends EntityMapper<CourseDTO,Course>{
}
