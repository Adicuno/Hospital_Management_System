package com.jsp.springboothospitalmanagementsystem.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column(nullable = false)
    private LocalDateTime appointmentTime;

    @Column(length = 500)
    private String reason;

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public LocalDateTime getAppointmentTime() {
        return appointmentTime;
    }

    public void setAppointmentTime(LocalDateTime appointmentTime) {
        this.appointmentTime = appointmentTime;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public Appointment() {
    }

    public Appointment(Long id, LocalDateTime appointmentTime, String reason) {
        Id = id;
        this.appointmentTime = appointmentTime;
        this.reason = reason;
    }
    @ManyToOne
    @JoinColumn(name = "patient_id", nullable = false)// patient is required
    private Patient patient;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Doctor doctor;
}
