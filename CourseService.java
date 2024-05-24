package com.shd.newSchoolManagement.service;

import com.shd.newSchoolManagement.service.dto.CourseDTO;

import java.util.List;
import java.util.Optional;

public interface CourseService {
    CourseDTO save(CourseDTO courseDTO);

    CourseDTO update(CourseDTO courseDTO);

    Optional<CourseDTO> partialUpdate(CourseDTO courseDTO);

    List<CourseDTO> getAllCourse();

    CourseDTO findOne(Long id);

    List<CourseDTO> courseByTeacherId(Long subTeacherId);

    List<CourseDTO> findCoursebyStudentId(Long id);

    void delete(Long id);

}
