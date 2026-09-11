package com.example.queue;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QueueRepository extends JpaRepository<Queue, Long> {

    List<Queue> findByDoctorIdAndQueueDateAndStatus(
            Long doctorId,
            String queueDate,
            String status
    );
}