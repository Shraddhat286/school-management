package com.shd.newSchoolManagement.domain;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "age")
    private Long age;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "division_id",referencedColumnName = "id")
    private Division division;


}
