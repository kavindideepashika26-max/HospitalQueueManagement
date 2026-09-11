package com.example.report;


import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class MedicalReportService {

    private final MedicalReportRepository repository;

    public MedicalReportService(MedicalReportRepository repository) {
        this.repository = repository;
    }

    // CREATE REPORT
    public MedicalReport createReport(MedicalReport report) {

        if (report.getRequestedAt() == null) {
            report.setRequestedAt(LocalDateTime.now());
        }

        if (report.getStatus() == null) {
            report.setStatus("PROCESSING");
        }

        return repository.save(report);
    }

    // GET ALL REPORTS
    public List<MedicalReport> getAllReports() {
        return repository.findAll();
    }

    // GET REPORT BY ID
    public Optional<MedicalReport> getReportById(Long id) {
        return repository.findById(id);
    }

    // GET REPORTS BY PATIENT
    public List<MedicalReport> getReportsByPatient(Long patientId) {
        return repository.findByPatientId(patientId);
    }

    // GET REPORTS BY DOCTOR
    public List<MedicalReport> getReportsByDoctor(Long doctorId) {
        return repository.findByDoctorId(doctorId);
    }

    // UPDATE REPORT
    public MedicalReport updateReport(
            Long id,
            MedicalReport reportDetails) {

        MedicalReport report = repository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Report not found"));

        report.setPatientId(reportDetails.getPatientId());
        report.setDoctorId(reportDetails.getDoctorId());
        report.setReportType(reportDetails.getReportType());
        report.setTestName(reportDetails.getTestName());
        report.setStatus(reportDetails.getStatus());
        report.setResult(reportDetails.getResult());
        report.setRemarks(reportDetails.getRemarks());
        report.setRequestedAt(reportDetails.getRequestedAt());
        report.setCompletedAt(reportDetails.getCompletedAt());
        report.setEstimatedCompletionTime(
                reportDetails.getEstimatedCompletionTime());

        return repository.save(report);
    }

    // COMPLETE REPORT
    public MedicalReport completeReport(
            Long id,
            String result,
            String remarks) {

        MedicalReport report = repository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Report not found"));

        report.setStatus("COMPLETED");
        report.setResult(result);
        report.setRemarks(remarks);
        report.setCompletedAt(LocalDateTime.now());

        return repository.save(report);
    }

    // DELETE REPORT
    public void deleteReport(Long id) {
        repository.deleteById(id);
    }
}