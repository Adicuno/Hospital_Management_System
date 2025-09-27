package com.jsp.springboothospitalmanagementsystem.repository;

import com.jsp.springboothospitalmanagementsystem.model.Patient;
import com.jsp.springboothospitalmanagementsystem.model.type.BloodGroupType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {
    Patient findByName(String name);
    List<Patient> findBYBirthDateorEmail(LocalDate birthDate,String email);
    List<Patient> findByNameContainingOrderByIdDesc(String query);

    @Query("select p from Patient p where p.bloodGroup = ?1")
    List<Patient> findByBloodGroup(@Param("bloodGroup") BloodGroupType bloodGroup);

    @Query("select p from Patient p where p.birthDate> :birthDate")
    List<Patient> findByBornAfterDate(@Param("birthDate") LocalDate birthDate);

}
