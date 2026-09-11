package com.example.doctor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/doctors")
public class DoctorController {

    private final DoctorService service;

    public DoctorController(DoctorService service) {
        this.service = service;
    }

    // CREATE
    @PostMapping
    public Doctor createDoctor(@RequestBody Doctor doctor) {
        return service.saveDoctor(doctor);
    }

    // GET ALL
    @GetMapping
    public List<Doctor> getAllDoctors() {
        return service.getAllDoctors();
    }

    // GET BY ID
    @GetMapping("/{id}")
    public ResponseEntity<Doctor> getDoctorById(@PathVariable Long id) {

        return service.getDoctorById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // UPDATE
    @PutMapping("/{id}")
    public ResponseEntity<Doctor> updateDoctor(
            @PathVariable Long id,
            @RequestBody Doctor doctor) {

        Doctor updated = service.updateDoctor(id, doctor);

        if (updated == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(updated);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteDoctor(@PathVariable Long id) {

        if (service.deleteDoctor(id)) {
            return ResponseEntity.ok("Doctor deleted successfully");
        }

        return ResponseEntity.notFound().build();
    }
}