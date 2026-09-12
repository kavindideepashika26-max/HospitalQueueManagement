package com.example.appointment;




import org.springframework.web.bind.annotation.*;

import java.util.List;



@RestController
@RequestMapping("/appointments")
public class appointmentController {



    private final appoinment_service service;

public appointmentController(appoinment_service service){

        this.service = service;
    }

 // CREATE

    @PostMapping
    public appointment addAppointment(
            @RequestBody appointment appointment){

        return service.save(appointment);
    }
 // READ ALL

    @GetMapping
    public List<appointment> getAppointments(){

        return service.getAll();
    }
// READ BY ID

    @GetMapping("/{id}")
    public appointment getAppointment(
            @PathVariable Long id){

        return service.getById(id);
    }
  // UPDATE

    @PutMapping("/{id}")
    public appointment updateAppointment(
            @PathVariable Long id,
            @RequestBody appointment appointment){

        return service.update(id,appointment);
    }
// DELETE

    @DeleteMapping("/{id}")
    public String deleteAppointment(
            @PathVariable Long id){


        service.delete(id);

        return "Deleted successfully";
    }

}
