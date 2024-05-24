package com.shd.newSchoolManagement.repository;

import com.shd.newSchoolManagement.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepo extends JpaRepository<Student,Long> {
    List<Student> findByDivisionId(Long id);
    @Query("SELECT COUNT(s) FROM Student s WHERE s.division.id = :divisionId")
    Long countStudentsInDivision(@Param("divisionId") Long divisionId);
}
