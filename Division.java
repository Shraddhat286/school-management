package com.shd.newSchoolManagement.domain;


import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "division")
public class Division {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

}
