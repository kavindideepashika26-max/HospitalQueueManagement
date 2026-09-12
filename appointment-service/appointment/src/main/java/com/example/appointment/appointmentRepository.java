package com.example.appointment;


import org.springframework.data.jpa.repository.JpaRepository;

public interface appointmentRepository 
        extends JpaRepository<appointment, Long> {

        }
