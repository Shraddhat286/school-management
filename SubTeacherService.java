package com.shd.newSchoolManagement.service;

import com.shd.newSchoolManagement.service.dto.StudentDTO;
import com.shd.newSchoolManagement.service.dto.SubTeacherDTO;

import java.util.List;
import java.util.Optional;

public interface SubTeacherService {
    SubTeacherDTO save(SubTeacherDTO subTeacherDTO);

    SubTeacherDTO update(SubTeacherDTO subTeacherDTO);

    Optional<SubTeacherDTO> partialUpdate(SubTeacherDTO subTeacherDTO);

    List<SubTeacherDTO> findAll();

    void deleteSubTeacher(Long id);


}
