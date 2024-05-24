package com.shd.newSchoolManagement.repository;

import com.shd.newSchoolManagement.domain.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface CourseRepo extends JpaRepository<Course,Long>{
    List<Course> findBySubTeacherId(Long subTeacherId);
    List<Course> findByStudentId(Long studentId);

}
