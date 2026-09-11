package com.example.report;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class MedicalReport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long patientId;

    private Long doctorId;

    private String reportType;

    private String testName;

    private String status;

    private String result;

    private String remarks;

    private LocalDateTime requestedAt;

    private LocalDateTime completedAt;

    private LocalDateTime estimatedCompletionTime;

    public MedicalReport() {
    }

    public MedicalReport(Long patientId,
                         Long doctorId,
                         String reportType,
                         String testName,
                         String status,
                         String result,
                         String remarks,
                         LocalDateTime requestedAt,
                         LocalDateTime completedAt,
                         LocalDateTime estimatedCompletionTime) {

        this.patientId = patientId;
        this.doctorId = doctorId;
        this.reportType = reportType;
        this.testName = testName;
        this.status = status;
        this.result = result;
        this.remarks = remarks;
        this.requestedAt = requestedAt;
        this.completedAt = completedAt;
        this.estimatedCompletionTime = estimatedCompletionTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPatientId() {
        return patientId;
    }

    public void setPatientId(Long patientId) {
        this.patientId = patientId;
    }

    public Long getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(Long doctorId) {
        this.doctorId = doctorId;
    }

    public String getReportType() {
        return reportType;
    }

    public void setReportType(String reportType) {
        this.reportType = reportType;
    }

    public String getTestName() {
        return testName;
    }

    public void setTestName(String testName) {
        this.testName = testName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public LocalDateTime getRequestedAt() {
        return requestedAt;
    }

    public void setRequestedAt(LocalDateTime requestedAt) {
        this.requestedAt = requestedAt;
    }

    public LocalDateTime getCompletedAt() {
        return completedAt;
    }

    public void setCompletedAt(LocalDateTime completedAt) {
        this.completedAt = completedAt;
    }

    public LocalDateTime getEstimatedCompletionTime() {
        return estimatedCompletionTime;
    }

    public void setEstimatedCompletionTime(
            LocalDateTime estimatedCompletionTime) {
        this.estimatedCompletionTime = estimatedCompletionTime;
    }
}