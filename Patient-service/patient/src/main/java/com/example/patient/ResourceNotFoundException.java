package com.example.patient;



public class ResourceNotFoundException extends RuntimeException {
    
    public ResourceNotFoundException(String resource, Long id) {
        super(resource + " not found with ID: " + id);
    }
    
    public ResourceNotFoundException(String message) {
        super(message);
    }
}