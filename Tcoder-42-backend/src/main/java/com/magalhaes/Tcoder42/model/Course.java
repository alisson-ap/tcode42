package com.magalhaes.Tcoder42.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
//@Table(name="cursos")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 200, nullable = false)
    private String name;

    @Column(length = 10, nullable = false)
    private String category;

}
