package com.shd.newSchoolManagement.service.impl;

import com.shd.newSchoolManagement.domain.Division;
import com.shd.newSchoolManagement.repository.DivisionRepo;
import com.shd.newSchoolManagement.service.DivisionService;
import com.shd.newSchoolManagement.service.dto.DivisionDTO;
import com.shd.newSchoolManagement.service.mapper.DivisionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DivisionServiceImpl implements DivisionService {

    @Autowired
    private DivisionRepo divisionRepo;

    @Autowired
    private DivisionMapper divisionMapper;

    @Override
    public DivisionDTO save(DivisionDTO divisionDTO) {
        Division division = divisionMapper.toEntity(divisionDTO);
        division = divisionRepo.save(division);
        return divisionMapper.toDto(division);
    }

    @Override
    public DivisionDTO update(DivisionDTO divisionDTO) {
        Division division = divisionMapper.toEntity(divisionDTO);
        division = divisionRepo.save(division);
        return divisionMapper.toDto(division);
    }

    @Override
    public Optional<Object> partialUpdate(Long id, DivisionDTO divisionDTO) {
        Optional<Division> divisionOptional = divisionRepo.findById(id);
        if (divisionOptional.isPresent()) {
            Division exist = divisionOptional.get();
            divisionMapper.partialUpdate(exist, divisionDTO);
            divisionRepo.save(exist);
            return Optional.ofNullable(divisionMapper.toDto(exist));
        }
        return Optional.empty();
    }

    @Override
    public List<DivisionDTO> findAll() {
        List<Division> division = divisionRepo.findAll();
        return divisionMapper.toDto(division);
    }

}
