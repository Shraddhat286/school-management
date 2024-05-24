package com.shd.newSchoolManagement.service.impl;

import com.shd.newSchoolManagement.domain.SubTeacher;
import com.shd.newSchoolManagement.repository.SubjectTeacherRepo;
import com.shd.newSchoolManagement.service.SubTeacherService;
import com.shd.newSchoolManagement.service.dto.SubTeacherDTO;
import com.shd.newSchoolManagement.service.mapper.SubTeacherMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SubTeacherImpl implements SubTeacherService {

    @Autowired
    SubjectTeacherRepo subjectTeacherRepo;

    @Autowired
    SubTeacherMapper subTeacherMapper;

    @Override
    public SubTeacherDTO save(SubTeacherDTO subTeacherDTO) {
        SubTeacher subTeacher = subTeacherMapper.toEntity(subTeacherDTO);
        subjectTeacherRepo.save(subTeacher);
        return subTeacherMapper.toDto(subTeacher);
    }

    @Override
    public SubTeacherDTO update(SubTeacherDTO subTeacherDTO) {
        SubTeacher subTeacher = subTeacherMapper.toEntity(subTeacherDTO);
        subjectTeacherRepo.save(subTeacher);
        return subTeacherMapper.toDto(subTeacher);
    }

    public Optional<SubTeacherDTO> partialUpdate(SubTeacherDTO subTeacherDTO) {
        Optional<SubTeacher> optional = subjectTeacherRepo.findById(subTeacherDTO.getId());
        SubTeacher sub = optional.get();
        if (optional.isPresent()) {
            subTeacherMapper.partialUpdate(sub, subTeacherDTO);
            subjectTeacherRepo.save(sub);
            return Optional.ofNullable(subTeacherMapper.toDto(sub));
        } else {
            return Optional.empty();
        }
    }

    @Override
    public List<SubTeacherDTO> findAll() {
        List<SubTeacher> subTeacher = subjectTeacherRepo.findAll();
        return subTeacherMapper.toDto(subTeacher);
    }

    @Override
    public void deleteSubTeacher(Long id) {
        subjectTeacherRepo.deleteById(id);

    }

}
