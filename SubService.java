package com.shd.newSchoolManagement.service;

import com.shd.newSchoolManagement.service.dto.SubjectDTO;
import com.shd.newSchoolManagement.web.rest.errors.BadRequestAlertException;

import java.util.List;
import java.util.Optional;

public interface SubService {
    SubjectDTO save(SubjectDTO subjectDTO);

    SubjectDTO update(SubjectDTO subjectDTO);

    Optional<SubjectDTO> partialUpdate(SubjectDTO subjectDTO);

    List<SubjectDTO> findAll();

    SubjectDTO findOne(Long id);

   List <SubjectDTO> findSubByCourseId(Long id) throws BadRequestAlertException;

    List <SubjectDTO> findBySubTeacherId(Long id);

    void delete(Long id);
}
