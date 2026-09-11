package com.example.queue;

import jakarta.persistence.*;

@Entity
@Table(name = "queue")
public class Queue {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long patientId;
    private Long doctorId;
    private int queueNumber;
    private String queueDate;
    private String status;
    private int estimatedWaitingTime;

    public Queue() {
    }

    public Queue(Long id, Long patientId, Long doctorId,
                 int queueNumber, String queueDate,
                 String status, int estimatedWaitingTime) {

        this.id = id;
        this.patientId = patientId;
        this.doctorId = doctorId;
        this.queueNumber = queueNumber;
        this.queueDate = queueDate;
        this.status = status;
        this.estimatedWaitingTime = estimatedWaitingTime;
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

    public int getQueueNumber() {
        return queueNumber;
    }

    public void setQueueNumber(int queueNumber) {
        this.queueNumber = queueNumber;
    }

    public String getQueueDate() {
        return queueDate;
    }

    public void setQueueDate(String queueDate) {
        this.queueDate = queueDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getEstimatedWaitingTime() {
        return estimatedWaitingTime;
    }

    public void setEstimatedWaitingTime(int estimatedWaitingTime) {
        this.estimatedWaitingTime = estimatedWaitingTime;
    }
}