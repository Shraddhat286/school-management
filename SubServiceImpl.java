package com.shd.newSchoolManagement.service.impl;

import com.shd.newSchoolManagement.domain.Subject;
import com.shd.newSchoolManagement.repository.SubRepo;
import com.shd.newSchoolManagement.service.SubService;
import com.shd.newSchoolManagement.service.dto.SubjectDTO;
import com.shd.newSchoolManagement.service.mapper.SubMapper;
import com.shd.newSchoolManagement.web.rest.errors.BadRequestAlertException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SubServiceImpl implements SubService {
    @Autowired
    private SubRepo subRepo;
    @Autowired
    private SubMapper subMapper;

    @Override
    public SubjectDTO save(SubjectDTO subjectDTO) {
        Subject subject = subMapper.toEntity(subjectDTO);
        subject = subRepo.save(subject);
        return subMapper.toDto(subject);
    }

    @Override
    public SubjectDTO update(SubjectDTO subjectDTO) {
        Subject subject = subMapper.toEntity(subjectDTO);
        subject = subRepo.save(subject);
        return subMapper.toDto(subject);
    }

    @Override
    public Optional<SubjectDTO> partialUpdate(SubjectDTO subjectDTO) {
        Optional<Subject> optSubject = subRepo.findById(subjectDTO.getId());
        if (optSubject.isPresent()) {
            Subject sub = optSubject.get();
            subMapper.partialUpdate(sub, subjectDTO);
            subRepo.save(sub);
            return Optional.of(subMapper.toDto(sub));
        } else {
            return Optional.empty();
        }
    }

    @Override
    public List<SubjectDTO> findAll() {
        List<Subject> sub = subRepo.findAll();
        List<SubjectDTO> subjectDTOS = subMapper.toDto(sub);
        return subjectDTOS;
    }

    @Override
    public SubjectDTO findOne(Long id) {
        Optional<Subject> ff = subRepo.findById(id);
        Subject sub = ff.get();
        return subMapper.toDto(sub);
    }

    @Override
    public List<SubjectDTO> findSubByCourseId(Long id) throws BadRequestAlertException {
        List<Subject> sub = subRepo.findSubjectByCourseId(id);
        if (sub != null) {
            return subMapper.toDto(sub);
        } else {
            throw new BadRequestAlertException("A subject not found");
        }
    }

    @Override
    public List<SubjectDTO> findBySubTeacherId(Long subTeacherId) {
        List<Subject> dd = subRepo.findSubjectBySubTeacherId(subTeacherId);
        return subMapper.toDto(dd);
    }

    @Override
    public void delete(Long id) {
        subRepo.deleteById(id);
    }
}
