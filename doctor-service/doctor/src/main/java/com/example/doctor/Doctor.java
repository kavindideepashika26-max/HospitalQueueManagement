package com.example.doctor;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fullName;
    private String email;
    private String phoneNo;
    private String specialization;
    private String qualification;
    private String consultationTime;
    private String consultationDates;

    public Doctor() {
    }

    public Doctor(String fullName, String email, String phoneNo,
                   String specialization, String qualification,
                   String consultationTime, String consultationDates) {

        this.fullName = fullName;
        this.email = email;
        this.phoneNo = phoneNo;
        this.specialization = specialization;
        this.qualification = qualification;
        this.consultationTime = consultationTime;
        this.consultationDates = consultationDates;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    public String getConsultationTime() {
        return consultationTime;
    }

    public void setConsultationTime(String consultationTime) {
        this.consultationTime = consultationTime;
    }

    public String getConsultationDates() {
        return consultationDates;
    }

    public void setConsultationDates(String consultationDates) {
        this.consultationDates = consultationDates;
    }
}