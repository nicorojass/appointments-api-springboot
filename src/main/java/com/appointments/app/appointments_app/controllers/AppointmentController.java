package com.appointments.app.appointments_app.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.appointments.app.appointments_app.models.Appointment;
import com.appointments.app.appointments_app.services.AppointmentService;

@RestController
@RequestMapping("/api/appointments")
public class AppointmentController {
    AppointmentService appointmentService;

    public AppointmentController(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }

    @PostMapping
    public Appointment createAppointment(@RequestBody Appointment appointment){
        return appointmentService.createAppointment(appointment);
    }

    @GetMapping("/{id}")
    public Appointment getAppointmentById(@PathVariable Long id){
        return appointmentService.searchAppointment(id);
    }

    @GetMapping
    public List<Appointment> getAllAppointments(){
        return appointmentService.getAllAppointments();
    }

    @PutMapping("/{id}/cancel")
    public void cancelAppointment(@PathVariable Long id){
        appointmentService.cancelAppointment(id);
    }

    
}
