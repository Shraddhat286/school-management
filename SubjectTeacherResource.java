package com.shd.newSchoolManagement.web.rest;

import com.shd.newSchoolManagement.repository.SubjectTeacherRepo;
import com.shd.newSchoolManagement.service.SubTeacherService;
import com.shd.newSchoolManagement.service.dto.SubTeacherDTO;
import com.shd.newSchoolManagement.web.rest.errors.BadRequestAlertException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class SubjectTeacherResource {

    @Autowired
    private SubTeacherService subTeacherService;

    @Autowired
    private SubjectTeacherRepo subjectTeacherRepo;


    @PostMapping("/sub-teacher")
    public ResponseEntity<SubTeacherDTO> saveSubjectTeacher(@RequestBody SubTeacherDTO subTeacherDTO) throws BadRequestAlertException {
        if (subTeacherDTO.getId() != null) {
            throw new BadRequestAlertException("SubjectTeacher cannot already have an id");
        }
        SubTeacherDTO result = subTeacherService.save(subTeacherDTO);
        return ResponseEntity.ok(result);

    }

    @PutMapping("/sub-teacher/{id}")
    public ResponseEntity<SubTeacherDTO> updateSubjectTeacher(@PathVariable Long id, @RequestBody SubTeacherDTO subTeacherDTO) throws BadRequestAlertException {
        if (subTeacherDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id");
        }
        if (Objects.equals(id, subTeacherDTO)) {
            throw new BadRequestAlertException("Invalid id");
        }
        if (!subjectTeacherRepo.existsById(id)) {
            throw new BadRequestAlertException("Entity not found");
        }
        SubTeacherDTO result = subTeacherService.update(subTeacherDTO);
        return ResponseEntity.ok(result);
    }

    @PatchMapping("/sub-teacher/{id}")
    public ResponseEntity<SubTeacherDTO> partialUpdate(@PathVariable Long id, @RequestBody SubTeacherDTO subTeacherDTO) throws BadRequestAlertException {
        if (subTeacherDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id");
        }
        if (Objects.equals(id, subTeacherDTO)) {
            throw new BadRequestAlertException("Invalid id");
        }
        if (!subjectTeacherRepo.existsById(id)) {
            throw new BadRequestAlertException("Entity not found");
        }
        Optional<SubTeacherDTO> result = subTeacherService.partialUpdate(subTeacherDTO);
        return ResponseEntity.of(result);
    }

    @GetMapping("/sub-teacher")
    public ResponseEntity<List<SubTeacherDTO>> getAllSubTeacher() {
        List<SubTeacherDTO> result = subTeacherService.findAll();
        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/sub-teacher/{id}")
    public ResponseEntity<Void> deleteSubTeacher(@PathVariable Long id) {
        subTeacherService.deleteSubTeacher(id);
        return ResponseEntity.ok().build();
    }

}
