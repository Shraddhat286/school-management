package com.shd.newSchoolManagement.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

import java.util.*;

@Data
@Entity
@Table(name = "course")
//std 1 2 3 4 5 6 7
public class Course {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;//std 1,2,3,4,

    @Column(name = "type")
    private String type; // semi/english

    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
    @JoinColumn(name = "student_id", referencedColumnName = "id")
    private Student student;

    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
    @JoinColumn(name = "sub_teacher_id", referencedColumnName = "id")
    private SubTeacher subTeacher;

}
