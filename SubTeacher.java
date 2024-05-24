package com.shd.newSchoolManagement.domain;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "subTeacher")
public class SubTeacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "salary")
    private double salary;

    @Column(name = "experience")
    private Long experience;

}
