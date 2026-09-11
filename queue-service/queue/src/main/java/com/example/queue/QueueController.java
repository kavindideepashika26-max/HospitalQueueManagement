package com.example.queue;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/queues")
public class QueueController {

    private final Queue_service service;

    public QueueController(Queue_service service) {
        this.service = service;
    }

    // JOIN QUEUE
    @PostMapping
    public Queue joinQueue(@RequestBody Queue queue) {
        return service.joinQueue(queue);
    }

    // GET ALL QUEUE
    @GetMapping
    public List<Queue> getAll() {
        return service.getAll();
    }

    // GET QUEUE BY ID
    @GetMapping("/{id}")
    public Queue getById(@PathVariable Long id) {
        return service.getById(id);
    }

    // GET PATIENT QUEUE
    @GetMapping("/patient/{patientId}")
    public List<Queue> getByPatientId(
            @PathVariable Long patientId) {

        return service.getByPatientId(patientId);
    }

    // UPDATE STATUS
    @PutMapping("/{id}/status")
    public Queue updateStatus(
            @PathVariable Long id,
            @RequestParam String status) {

        return service.updateStatus(id, status);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {

        service.delete(id);

        return "Queue entry deleted successfully";
    }
}