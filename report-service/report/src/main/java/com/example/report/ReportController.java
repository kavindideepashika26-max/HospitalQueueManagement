package com.example.report;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reports")
@CrossOrigin
public class ReportController {

    private final MedicalReportService reportService;

    public ReportController(MedicalReportService reportService) {
        this.reportService = reportService;
    }

    // GET ALL REPORTS
    @GetMapping
    public List<MedicalReport> getAllReports() {
        return reportService.getAllReports();
    }

    // GET REPORT BY ID
    @GetMapping("/{id}")
    public ResponseEntity<MedicalReport> getReportById(
            @PathVariable Long id) {

        return reportService.getReportById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // GET REPORTS OF A PATIENT
    @GetMapping("/patient/{patientId}")
    public List<MedicalReport> getReportsByPatient(
            @PathVariable Long patientId) {

        return reportService.getReportsByPatient(patientId);
    }

    // GET REPORTS OF A DOCTOR
    @GetMapping("/doctor/{doctorId}")
    public List<MedicalReport> getReportsByDoctor(
            @PathVariable Long doctorId) {

        return reportService.getReportsByDoctor(doctorId);
    }

    // CREATE REPORT
    @PostMapping
    public MedicalReport createReport(
            @RequestBody MedicalReport report) {

        return reportService.createReport(report);
    }

    // UPDATE REPORT
    @PutMapping("/{id}")
    public ResponseEntity<MedicalReport> updateReport(
            @PathVariable Long id,
            @RequestBody MedicalReport report) {

        try {
            return ResponseEntity.ok(
                    reportService.updateReport(id, report)
            );
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    // COMPLETE REPORT
    @PutMapping("/{id}/complete")
    public ResponseEntity<MedicalReport> completeReport(
            @PathVariable Long id,
            @RequestParam String result,
            @RequestParam(required = false) String remarks) {

        try {
            return ResponseEntity.ok(
                    reportService.completeReport(
                            id, result, remarks)
            );
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    // DELETE REPORT
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReport(
            @PathVariable Long id) {

        reportService.deleteReport(id);

        return ResponseEntity.noContent().build();
    }
}