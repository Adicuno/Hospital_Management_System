package com.jsp.springboothospitalmanagementsystem.repository;

import com.jsp.springboothospitalmanagementsystem.model.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {
}