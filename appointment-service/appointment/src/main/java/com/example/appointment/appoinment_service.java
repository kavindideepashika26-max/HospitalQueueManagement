package com.example.appointment;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class appoinment_service {

    private final appointmentRepository repository;

    public appoinment_service(appointmentRepository repository) {
        this.repository = repository;
    }

    // CREATE
    public appointment save(appointment appointment) {
        return repository.save(appointment);
    }

    // READ ALL
    public List<appointment> getAll() {
        return repository.findAll();
    }

    // READ BY ID
    public appointment getById(Long id) {
        return repository.findById(id)
                .orElse(null);
    }

    // UPDATE
    public appointment update(Long id, appointment data) {

        appointment existing = repository.findById(id)
                .orElse(null);

        if (existing != null) {

            existing.setPatientId(data.getPatientId());
            existing.setDoctorName(data.getDoctorName());
            existing.setAppointmentDate(data.getAppointmentDate());
            existing.setAppointmentTime(data.getAppointmentTime());
            existing.setStatus(data.getStatus());

            return repository.save(existing);
        }

        return null;
    }

    // DELETE
    public void delete(Long id) {
        repository.deleteById(id);
    }
}