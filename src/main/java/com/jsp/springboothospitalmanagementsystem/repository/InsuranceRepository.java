package com.jsp.springboothospitalmanagementsystem.repository;

import com.jsp.springboothospitalmanagementsystem.model.Insurance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InsuranceRepository extends JpaRepository<Insurance, Long> {
}