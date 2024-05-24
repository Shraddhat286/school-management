package com.shd.newSchoolManagement.repository;

import com.shd.newSchoolManagement.domain.SubTeacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubjectTeacherRepo extends JpaRepository<SubTeacher,Long> {

}
