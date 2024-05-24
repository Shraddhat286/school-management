package com.shd.newSchoolManagement.web.rest;

import com.shd.newSchoolManagement.repository.SubRepo;
import com.shd.newSchoolManagement.service.SubService;
import com.shd.newSchoolManagement.service.dto.SubjectDTO;
import com.shd.newSchoolManagement.web.rest.errors.BadRequestAlertException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class SubjectResource {

    @Autowired
    private SubService subService;

    @Autowired
    private SubRepo subRepo;

    @PostMapping("/subject")
    public ResponseEntity<SubjectDTO> createSubject(@RequestBody SubjectDTO subjectDTO) throws BadRequestAlertException {
        if (subjectDTO.getId() != null) {
            throw new BadRequestAlertException("Subject cannot already have an ID ");
        }
        SubjectDTO result = subService.save(subjectDTO);
        return ResponseEntity.ok(result);
    }

    @PutMapping("/subject/{id}")
    public ResponseEntity<SubjectDTO> updateStudent(@PathVariable Long id, @RequestBody SubjectDTO subjectDTO) throws BadRequestAlertException {
        if (subjectDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id");
        }
        if (Objects.equals(id, subjectDTO.getId())) {
            throw new BadRequestAlertException("Invalid id");
        }
        if (!subRepo.existsById(id)) {
            throw new BadRequestAlertException("Entity not found");
        }
        SubjectDTO result = subService.update(subjectDTO);
        return ResponseEntity.ok(result);
    }

    @PatchMapping("/subject/{id}")
    public ResponseEntity<Optional<SubjectDTO>> partialUpdate(@PathVariable Long id, SubjectDTO subjectDTO) throws BadRequestAlertException {
        if (subjectDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id");
        }
        if (Objects.equals(id, subjectDTO.getId())) {
            throw new BadRequestAlertException("Invalid id");
        }
        if (!subRepo.existsById(id)) {
            throw new BadRequestAlertException("Entity not found");
        }
        Optional<SubjectDTO> result = subService.partialUpdate(subjectDTO);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/subject")
    public ResponseEntity<List<SubjectDTO>> getAllSubject() {
        List<SubjectDTO> result = subService.findAll();
        return ResponseEntity.ok(result);
    }

    @GetMapping("/subject/{id}")
    public ResponseEntity<SubjectDTO> findById(@PathVariable Long id) {
        SubjectDTO result = subService.findOne(id);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/sub-course/{id}")
    public ResponseEntity<List<SubjectDTO>> findSubByCourseId(@PathVariable Long id) throws BadRequestAlertException {
        List<SubjectDTO> result = subService.findSubByCourseId(id);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/sub-teacher/{id}")
    public ResponseEntity<List<SubjectDTO>> findBySubTeacherId(@PathVariable Long id) {
        List<SubjectDTO> result = subService.findBySubTeacherId(id);
        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/subject/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        subService.delete(id);
        return ResponseEntity.noContent().build();
    }


}
