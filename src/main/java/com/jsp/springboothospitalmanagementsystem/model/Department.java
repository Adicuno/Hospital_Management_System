package com.jsp.springboothospitalmanagementsystem.model;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

@Entity
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false,unique = true,length = 100)
    private String name;

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

    public Department() {
    }

    public Department(Long id, String name) {
        this.id = id;
        this.name = name;
    }
    @OneToOne
    private Doctor headDoctor;

    @ManyToMany
    @JoinTable(
            name = "my_dept_doctors",
            joinColumns = @JoinColumn(name="dpt_id"),
            inverseJoinColumns = @JoinColumn(name ="doctor_id")
    )
    private Set<Doctor> doctors= new HashSet<>();
}
