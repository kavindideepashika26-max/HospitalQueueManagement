package com.example.queue;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class Queue_service {

    private final QueueRepository repository;

    // Average consultation time per patient
    private static final int AVERAGE_CONSULTATION_TIME = 10;

    public Queue_service(QueueRepository repository) {
        this.repository = repository;
    }

    // CREATE / JOIN QUEUE
    public Queue joinQueue(Queue queue) {

        String today = LocalDate.now().toString();

        queue.setQueueDate(today);
        queue.setStatus("WAITING");

        // Find today's waiting patients for the same doctor
        List<Queue> waitingPatients =
                repository.findByDoctorIdAndQueueDateAndStatus(
                        queue.getDoctorId(),
                        today,
                        "WAITING"
                );

        // Generate queue number
        int queueNumber = waitingPatients.size() + 1;

        queue.setQueueNumber(queueNumber);

        // Calculate estimated waiting time
        int waitingTime =
                waitingPatients.size() * AVERAGE_CONSULTATION_TIME;

        queue.setEstimatedWaitingTime(waitingTime);

        return repository.save(queue);
    }

    // READ ALL
    public List<Queue> getAll() {
        return repository.findAll();
    }

    // READ BY ID
    public Queue getById(Long id) {
        return repository.findById(id)
                .orElse(null);
    }

    // FIND PATIENT'S QUEUE
    public List<Queue> getByPatientId(Long patientId) {
        return repository.findAll()
                .stream()
                .filter(q -> q.getPatientId().equals(patientId))
                .toList();
    }

    // UPDATE STATUS
    public Queue updateStatus(Long id, String status) {

        Queue existing = repository.findById(id)
                .orElse(null);

        if (existing != null) {

            existing.setStatus(status);

            return repository.save(existing);
        }

        return null;
    }

    // DELETE
    public void delete(Long id) {
        repository.deleteById(id);
    }
}