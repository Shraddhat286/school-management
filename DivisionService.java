package com.shd.newSchoolManagement.service;

import com.shd.newSchoolManagement.service.dto.DivisionDTO;

import java.util.List;
import java.util.Optional;

public interface DivisionService {
    DivisionDTO save(DivisionDTO divisionDTO);

    DivisionDTO update(DivisionDTO divisionDTO);

    Optional<Object> partialUpdate(Long id, DivisionDTO divisionDTO);

    List<DivisionDTO> findAll();

}
