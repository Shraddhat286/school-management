package com.shd.newSchoolManagement.service.impl;

import com.shd.newSchoolManagement.domain.Course;
import com.shd.newSchoolManagement.repository.CourseRepo;
import com.shd.newSchoolManagement.service.CourseService;
import com.shd.newSchoolManagement.service.dto.CourseDTO;
import com.shd.newSchoolManagement.service.mapper.CourseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseRepo courseRepo;

    @Autowired
    private CourseMapper courseMapper;

    @Override
    public CourseDTO save(CourseDTO courseDTO) {
        Course course = courseMapper.toEntity(courseDTO);
        course = courseRepo.save(course);
        return courseMapper.toDto(course);
    }

    @Override
    public CourseDTO update(CourseDTO courseDTO) {
        Course course = courseMapper.toEntity(courseDTO);
        course = courseRepo.save(course);
        return courseMapper.toDto(course);
    }

    @Override
    public Optional<CourseDTO> partialUpdate(CourseDTO courseDTO) {
        return courseRepo.findById(courseDTO.getId()).map(
                        existingCourse -> {
                            courseMapper.partialUpdate(existingCourse, courseDTO);
                            return existingCourse;
                        }).map(courseRepo::save)
                .map(courseMapper::toDto);
    }

    @Override
    public List<CourseDTO> getAllCourse() {
        List<Course> course = courseRepo.findAll();
        return courseMapper.toDto(course);
    }

    @Override
    public CourseDTO findOne(Long id) {
        Optional<Course> course = courseRepo.findById(id);
        Course course1 = course.get();
        return courseMapper.toDto(course1);
    }

    @Override
    public List<CourseDTO> courseByTeacherId(Long subTeacherId) {
        List<Course> cc = courseRepo.findBySubTeacherId(subTeacherId);
        return courseMapper.toDto(cc);
    }

    @Override
    public List<CourseDTO> findCoursebyStudentId(Long studentId) {
        List<Course> cc = courseRepo.findByStudentId(studentId);
        return courseMapper.toDto(cc);
    }

    @Override
    public void delete(Long id) {
        courseRepo.deleteById(id);
    }

}
