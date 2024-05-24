package com.shd.newSchoolManagement.repository;

import com.shd.newSchoolManagement.domain.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubRepo extends JpaRepository<Subject,Long> {
   List <Subject> findSubjectByCourseId(Long courseId);

   List<Subject> findSubjectBySubTeacherId(Long subTeacherId);
}