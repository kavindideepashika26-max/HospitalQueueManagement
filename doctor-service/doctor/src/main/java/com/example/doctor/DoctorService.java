package com.example.doctor;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DoctorService {

    private final DoctorRepository repository;

    public DoctorService(DoctorRepository repository) {
        this.repository = repository;
    }

    // CREATE
    public Doctor saveDoctor(Doctor doctor) {
        return repository.save(doctor);
    }

    // GET ALL
    public List<Doctor> getAllDoctors() {
        return repository.findAll();
    }

    // GET BY ID
    public Optional<Doctor> getDoctorById(Long id) {
        return repository.findById(id);
    }

    // UPDATE
    public Doctor updateDoctor(Long id, Doctor updatedDoctor) {

        return repository.findById(id).map(doctor -> {

            doctor.setFullName(updatedDoctor.getFullName());
            doctor.setEmail(updatedDoctor.getEmail());
            doctor.setPhoneNo(updatedDoctor.getPhoneNo());
            doctor.setSpecialization(updatedDoctor.getSpecialization());
            doctor.setQualification(updatedDoctor.getQualification());
            doctor.setConsultationTime(updatedDoctor.getConsultationTime());
            doctor.setConsultationDates(updatedDoctor.getConsultationDates());

            return repository.save(doctor);

        }).orElse(null);
    }

    // DELETE
    public boolean deleteDoctor(Long id) {

        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        }

        return false;
    }
}