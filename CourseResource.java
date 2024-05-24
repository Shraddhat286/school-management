package com.shd.newSchoolManagement.web.rest;

import com.shd.newSchoolManagement.repository.CourseRepo;
import com.shd.newSchoolManagement.service.CourseService;
import com.shd.newSchoolManagement.service.dto.CourseDTO;
import com.shd.newSchoolManagement.web.rest.errors.BadRequestAlertException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.Optional;


@RestController
@RequestMapping("/api")
public class CourseResource {

    @Autowired
    private CourseService courseService;

    @Autowired
    private CourseRepo courseRepo;

    @PostMapping("/course")
    public ResponseEntity<CourseDTO> createCourse(@RequestBody CourseDTO courseDTO) throws BadRequestAlertException {
        if (courseDTO.getId() != null) {
            throw new BadRequestAlertException("A Course cannot already have an id");
        }
        CourseDTO result = courseService.save(courseDTO);
        return ResponseEntity.ok(result);
    }

    @PutMapping("/course/{id}")
    public ResponseEntity<CourseDTO> updateCourse(@PathVariable Long id, @RequestBody CourseDTO courseDTO) throws BadRequestAlertException {

        if (courseDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id");
        }
        if (!Objects.equals(id, courseDTO.getId())) {
            throw new BadRequestAlertException("Invalid id");
        }
        if (!courseRepo.existsById(id)) {
            throw new BadRequestAlertException("Entity not found");
        }
        CourseDTO result = courseService.update(courseDTO);
        return ResponseEntity.ok(result);
    }

    @PatchMapping("/course/{id}")
    public ResponseEntity<CourseDTO> partialUpdate(@PathVariable(value = "id", required = false) Long id, @RequestBody CourseDTO courseDTO) throws BadRequestAlertException {
        if (courseDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id");
        }
        if (!Objects.equals(id, courseDTO.getId())) {
            throw new BadRequestAlertException("Invalid id");
        }
        if (!courseRepo.existsById(id)) {
            throw new BadRequestAlertException("Entity not found");
        }
        Optional<CourseDTO> result = courseService.partialUpdate(courseDTO);
        return ResponseEntity.of(result);
    }

    @GetMapping("/course")
    public ResponseEntity<List<CourseDTO>> getAll() {
        List<CourseDTO> result = courseService.getAllCourse();
        return ResponseEntity.ok(result);
    }

    @GetMapping("/course/{id}")
    public ResponseEntity<CourseDTO> getCourse(@PathVariable Long id) {
        CourseDTO result = courseService.findOne(id);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/course-teacher/{TeacherId}")
    public ResponseEntity<List<CourseDTO>> courseByTeacherId(@PathVariable(value = "TeacherId") Long id) {
        List<CourseDTO> result = courseService.courseByTeacherId(id);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/course-student/{studentId}")
    public ResponseEntity<List<CourseDTO>> findCourseByStudentId(@PathVariable("studentId") Long id) {
        List<CourseDTO> result = courseService.findCoursebyStudentId(id);
        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/course/{id}")
    public ResponseEntity<Void> deleteCourse(@PathVariable Long id) {
        courseService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
