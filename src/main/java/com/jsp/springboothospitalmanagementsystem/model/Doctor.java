package com.jsp.springboothospitalmanagementsystem.model;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false,length = 100)
    private String name;
    @Column(length = 100)
    private String specialization;

    @Column(nullable=false,unique = true,length = 100)
    private String email;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Doctor() {
    }

    public Doctor(Long id, String name, String specialization, String email) {
        this.id = id;
        this.name = name;
        this.specialization = specialization;
        this.email = email;
    }

    @ManyToMany(mappedBy ="doctors" )
    private Set<Department> departments = new HashSet<>();

}
