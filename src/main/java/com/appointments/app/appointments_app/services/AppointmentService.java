package com.appointments.app.appointments_app.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.appointments.app.appointments_app.models.Appointment;
import com.appointments.app.appointments_app.models.Status;
import com.appointments.app.appointments_app.repositories.AppointmentRepository;

@Service
public class AppointmentService {
    private final AppointmentRepository appointmentRepo;

    public AppointmentService(AppointmentRepository appointmentRepo) {
        this.appointmentRepo = appointmentRepo;
    }

    public Appointment createAppointment(Appointment newAppointment){
        return appointmentRepo.save(newAppointment);
    }
    
    public Appointment searchAppointment(Long id){
        return appointmentRepo.findById(id).orElseThrow(() -> new IllegalArgumentException("No se encontro un turno con ese ID"));
    }

    public void cancelAppointment(Long id){
        Appointment appointment = searchAppointment(id);

        if (appointment.getStatus() == Status.CANCELED){
            throw new IllegalStateException("Este turno ya esta cancelado");
        }

        appointment.setStatus(Status.CANCELED);
        appointmentRepo.save(appointment);

    }

    public List<Appointment> getAllAppointments(){
        return (List<Appointment>) appointmentRepo.findAll();
    }

}
