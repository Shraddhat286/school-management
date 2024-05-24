package com.shd.newSchoolManagement.service;

import com.shd.newSchoolManagement.service.dto.StudentDTO;

import java.util.List;
import java.util.Optional;

public interface StudentService {
    StudentDTO save(StudentDTO studentDTO);

    StudentDTO update(StudentDTO studentDTO);

    Optional<StudentDTO> partialUpdate(StudentDTO studentDTO);

    List<StudentDTO> findAll();

    StudentDTO findOne(Long id);

    List<StudentDTO> getStudentByDivision(Long id);

    Long count(Long id);
    void delete(Long id);

}
