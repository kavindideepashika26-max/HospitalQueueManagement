package com.example.report;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicalReportRepository
        extends JpaRepository<MedicalReport, Long> {

    List<MedicalReport> findByPatientId(Long patientId);

    List<MedicalReport> findByDoctorId(Long doctorId);
}