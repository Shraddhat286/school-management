package com.shd.newSchoolManagement.service.impl;

import com.shd.newSchoolManagement.domain.Student;
import com.shd.newSchoolManagement.repository.StudentRepo;
import com.shd.newSchoolManagement.service.StudentService;
import com.shd.newSchoolManagement.service.dto.StudentDTO;
import com.shd.newSchoolManagement.service.mapper.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentMapper studentMapper;
    @Autowired
    private StudentRepo studentRepo;

    public StudentDTO save(StudentDTO studentDTO) {
        Student student = studentMapper.toEntity(studentDTO);
        student = studentRepo.save(student);
        return studentMapper.toDto(student);
    }

    @Override
    public StudentDTO update(StudentDTO studentDTO) {
        Student student = studentMapper.toEntity(studentDTO);
        student = studentRepo.save(student);
        return studentMapper.toDto(student);
    }

    @Override
    public Optional<StudentDTO> partialUpdate(StudentDTO studentDTO) {
        Optional<Student> existOptional = studentRepo.findById(studentDTO.getId());
        if (existOptional.isPresent()) {
            Student exist = existOptional.get();
            studentMapper.partialUpdate(exist, studentDTO);
            studentRepo.save(exist);
            return Optional.of(studentMapper.toDto(exist));
        } else {
            return Optional.empty();
        }
    }

    public List<StudentDTO> findAll() {
        List<Student> studentList = studentRepo.findAll();
        return studentMapper.toDto(studentList);
    }

    @Override
    public StudentDTO findOne(Long id) {
        Student student = studentRepo.getById(id);
        if (student != null) {
            StudentDTO studentDTO = studentMapper.toDto(student);
            return studentDTO;
        } else {
            throw new RuntimeException("id not found");
        }
    }

    @Override
    public List<StudentDTO> getStudentByDivision(Long id) {
        List<Student> ss = studentRepo.findByDivisionId(id);
        return studentMapper.toDto(ss);
    }

    @Override
    public Long count(Long divisionId) {
        Long count = studentRepo.countStudentsInDivision(divisionId);
        return count;
    }

    @Override
    public void delete(Long id) {
        studentRepo.deleteById(id);

    }
}
