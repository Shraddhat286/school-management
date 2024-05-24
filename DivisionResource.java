package com.shd.newSchoolManagement.web.rest;

import com.shd.newSchoolManagement.repository.DivisionRepo;
import com.shd.newSchoolManagement.service.DivisionService;
import com.shd.newSchoolManagement.service.dto.DivisionDTO;
import com.shd.newSchoolManagement.web.rest.errors.BadRequestAlertException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class DivisionResource {

    @Autowired
    private DivisionService divisionService;

    @Autowired
    private DivisionRepo divisionRepo;

    @PostMapping("/division")
    public ResponseEntity<DivisionDTO> saveDivision(@RequestBody DivisionDTO divisionDTO) throws BadRequestAlertException {
        if (divisionDTO.getId() != null) {
            throw new BadRequestAlertException(" Division cannot already have an id");
        }
        DivisionDTO result = divisionService.save(divisionDTO);
        return ResponseEntity.ok(result);
    }

    @PutMapping("/division/{id}")
    public ResponseEntity<DivisionDTO> updateDivision(@PathVariable Long id, @RequestBody DivisionDTO divisionDTO) throws BadRequestAlertException {
        if (divisionDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id");
        }
        if (!Objects.equals(id, divisionDTO.getId())) {
            throw new BadRequestAlertException("Invalid id");
        }
        if (!divisionRepo.existsById(id)) {
            throw new BadRequestAlertException("Entity not found");
        }
        DivisionDTO result = divisionService.update(divisionDTO);
        return ResponseEntity.ok(result);
    }

    @PatchMapping("/division/{id}")
    public ResponseEntity<Optional<Object>> partialUpdate(@PathVariable Long id, @RequestBody DivisionDTO divisionDTO) throws BadRequestAlertException {
        if (divisionDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id");
        }
        if (!Objects.equals(id, divisionDTO.getId())) {
            throw new BadRequestAlertException("Invalid id");
        }
        if (!divisionRepo.existsById(id)) {
            throw new BadRequestAlertException("Entity not found");
        }
        Optional<Object> result = divisionService.partialUpdate(id, divisionDTO);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/division")
    public ResponseEntity<List<DivisionDTO>> getAll() {
        List<DivisionDTO> result = divisionService.findAll();
        return ResponseEntity.ok(result);
    }


}
