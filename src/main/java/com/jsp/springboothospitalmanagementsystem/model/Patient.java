package com.jsp.springboothospitalmanagementsystem.model;

import com.jsp.springboothospitalmanagementsystem.model.type.BloodGroupType;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;


@Entity
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false,length = 40)
    private String name;

    private LocalDate birthDate;

    @Column(nullable = false,unique = true)
    private String email;

    private String gender;

    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime createdAt;

    @Enumerated(EnumType.STRING)
    private BloodGroupType bloodGroup;

    public Patient(long id, String name, LocalDate birthDate, String email, String gender, LocalDateTime createdAt, String bloodGroup) {
        this.id = id;
        this.name = name;
        this.birthDate = birthDate;
        this.email = email;
        this.gender = gender;
        this.createdAt = createdAt;
        this.bloodGroup = BloodGroupType.valueOf(bloodGroup);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public BloodGroupType getBloodGroup() {
        return bloodGroup;
    }

    public void setBloodGroup(String bloodGroup) {
        this.bloodGroup = BloodGroupType.valueOf(bloodGroup);
    }

    public Patient() {

    }
    @OneToOne
    @JoinColumn(name = "patient_insurance_id") // owning Side
    private Insurance insurance;

    @OneToMany(mappedBy = "patient")
    private List<Appointment> appointments;
}
