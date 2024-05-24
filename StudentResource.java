package com.shd.newSchoolManagement.web.rest;

import com.shd.newSchoolManagement.repository.StudentRepo;
import com.shd.newSchoolManagement.service.StudentService;
import com.shd.newSchoolManagement.service.dto.StudentDTO;
import com.shd.newSchoolManagement.web.rest.errors.BadRequestAlertException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class StudentResource {

    @Autowired
    private StudentService studentService;

    @Autowired
    private StudentRepo studentRepo;

    @PostMapping("/student")
    public ResponseEntity<StudentDTO> saveStudent(@RequestBody StudentDTO studentDTO) throws BadRequestAlertException {
        if (studentDTO.getId() != null) {
            throw new BadRequestAlertException("Student cannot already have an id");
        }
        StudentDTO result = studentService.save(studentDTO);
        return ResponseEntity.ok(result);
    }

    @PutMapping("/student/{id}")
    public ResponseEntity<StudentDTO> updateStudent(@PathVariable Long id, @RequestBody StudentDTO studentDTO) throws BadRequestAlertException {
        if (studentDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id");
        }
        if (!Objects.equals(id, studentDTO.getId())) {
            throw new BadRequestAlertException("Invalid id");
        }
        if (!studentRepo.existsById(id)) {
            throw new BadRequestAlertException("Entity not found");
        }
        StudentDTO result = studentService.update(studentDTO);
        return ResponseEntity.ok(result);
    }

    @PatchMapping("/student/{id}")
    public ResponseEntity<StudentDTO> partialUpdate(@PathVariable(value = "id", required = false) Long id, @RequestBody StudentDTO studentDTO) throws BadRequestAlertException {
        if (studentDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id");
        }
        if (!Objects.equals(id, studentDTO.getId())) {
            throw new BadRequestAlertException("Invalid id");
        }
        if (!studentRepo.existsById(id)) {
            throw new BadRequestAlertException("Entity not found");
        }
        Optional<StudentDTO> result = studentService.partialUpdate(studentDTO);
        return ResponseEntity.of(result);
    }

    @GetMapping("/student")
    public ResponseEntity<List<StudentDTO>> getAll() {
        List<StudentDTO> result = studentService.findAll();
        return ResponseEntity.ok(result);
    }

    @GetMapping("/student/{id}")
    public ResponseEntity<StudentDTO> getById(@PathVariable Long id) {
        if (id == null) {
            throw new RuntimeException("Id not valid");
        }
        StudentDTO result = studentService.findOne(id);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/division/{id}")
    public ResponseEntity<List<StudentDTO>> getStudentByDivision(@PathVariable Long id) {
        List<StudentDTO> result = studentService.getStudentByDivision(id);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/student-division/{divisionId}")
    public ResponseEntity<Long> countStudentsInDivision(@PathVariable("divisionId") Long id) {
        Long count = studentService.count(id);
        return ResponseEntity.ok(count);
    }

    @DeleteMapping("/student/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable Long id) {
        studentService.delete(id);
        return ResponseEntity.ok().build();
    }

}
