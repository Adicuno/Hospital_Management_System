package com.jsp.springboothospitalmanagementsystem.repository;

import com.jsp.springboothospitalmanagementsystem.model.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
}