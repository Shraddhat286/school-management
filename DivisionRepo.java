package com.shd.newSchoolManagement.repository;
import com.shd.newSchoolManagement.domain.Division;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DivisionRepo extends JpaRepository<Division,Long>{

}

