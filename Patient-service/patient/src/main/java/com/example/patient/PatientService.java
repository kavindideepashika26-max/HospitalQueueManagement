package com.example.patient;



import com.example.patient.Patient;
import com.example.patient.ResourceNotFoundException;
import com.example.patient.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService {
    
    @Autowired
    private PatientRepository patientRepository;
    
    // CREATE
    public Patient savePatient(Patient patient) {
        return patientRepository.save(patient);
    }
    
    // READ - Get all
    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }
    
    // READ - Get by ID
    public Patient getPatientById(Long id) {
        return patientRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Patient", id));
    }
    
    // UPDATE
    public Patient updatePatient(Long id, Patient patientDetails) {
        Patient existingPatient = getPatientById(id);
        existingPatient.setName(patientDetails.getName());
        existingPatient.setAge(patientDetails.getAge());
        existingPatient.setDisease(patientDetails.getDisease());
        existingPatient.setEmail(patientDetails.getEmail());
        existingPatient.setPhoneNumber(patientDetails.getPhoneNumber());
        return patientRepository.save(existingPatient);
    }
    
    // DELETE
    public void deletePatient(Long id) {
        Patient patient = getPatientById(id);
        patientRepository.delete(patient);
    }
    
    // CHECK if exists
    public boolean patientExists(Long id) {
        return patientRepository.existsById(id);
    }
}
