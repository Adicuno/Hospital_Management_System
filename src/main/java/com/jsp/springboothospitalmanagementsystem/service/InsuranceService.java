package com.jsp.springboothospitalmanagementsystem.service;

import com.jsp.springboothospitalmanagementsystem.model.Insurance;
import com.jsp.springboothospitalmanagementsystem.model.Patient;
import com.jsp.springboothospitalmanagementsystem.repository.InsuranceRepository;
import com.jsp.springboothospitalmanagementsystem.repository.PatientRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class InsuranceService {

    private InsuranceRepository insuranceRepository;
    private PatientRepository patientRepository;

    public void assignInsuranceToPatient(Insurance insurance,Long patientId ) {
        Patient patient = patientRepository.findById(patientId)
                .orElseThrow(()->new EntityNotFoundException("Patient not found"));

        patient.setInsurance(insurance);

        insurance.setPatient(patient); //bidirectional consistency maintainance
    }
}
