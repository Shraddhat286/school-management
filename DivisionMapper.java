package com.shd.newSchoolManagement.service.mapper;

import com.shd.newSchoolManagement.domain.Division;
import com.shd.newSchoolManagement.service.dto.DivisionDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DivisionMapper extends EntityMapper<DivisionDTO, Division>{

}
