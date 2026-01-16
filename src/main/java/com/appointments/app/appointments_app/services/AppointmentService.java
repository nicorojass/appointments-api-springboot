package com.appointments.app.appointments_app.services;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.appointments.app.appointments_app.models.Appointment;
import com.appointments.app.appointments_app.models.Status;
import com.appointments.app.appointments_app.repositories.AppointmentRepository;
import com.appointments.app.appointments_app.repositories.UserRepository;

@Service
public class AppointmentService {
    private final AppointmentRepository appointmentRepo;
    private final UserRepository userRepo;

    public AppointmentService(AppointmentRepository appointmentRepo,UserRepository userRepo) {
        this.appointmentRepo = appointmentRepo;
        this.userRepo = userRepo;
    }

    public Appointment createAppointment(Appointment newAppointment){

    if (appointmentRepo.existsByDateAndTimeAndStatus(
            newAppointment.getDate(),
            newAppointment.getTime(),
            Status.ACTIVE)) {

        throw new IllegalArgumentException("Ya existe un turno para esa fecha y hora");
    }

    if (newAppointment.getDate().isBefore(LocalDate.now())) {
        throw new IllegalArgumentException("No se puede crear un turno en una fecha pasada");
    }

    if (newAppointment.getDate().isEqual(LocalDate.now()) &&
        newAppointment.getTime().isBefore(LocalTime.now())) {

        throw new IllegalArgumentException("No se puede crear un turno en un horario pasado");
    }

    if (!userRepo.existsById(newAppointment.getUser().getId())){
        throw new IllegalArgumentException("No se encontro un usuario con ese ID");
    }

    newAppointment.setStatus(Status.ACTIVE);
    return appointmentRepo.save(newAppointment);
}

    public Appointment searchAppointment(Long id){
        return appointmentRepo.findById(id).orElseThrow(() -> new IllegalArgumentException("No se encontro un turno con ese ID"));
    }

    public Appointment cancelAppointment(Long id){
        Appointment appointment = searchAppointment(id);

        if (appointment.getStatus() == Status.CANCELED){
            throw new IllegalStateException("Este turno ya esta cancelado");
        }

        appointment.setStatus(Status.CANCELED);
        return appointmentRepo.save(appointment);
    }

    public List<Appointment> getAllAppointments(){
        return (List<Appointment>) appointmentRepo.findAll();
    }

    public void deleteAppointment(Long id){
        Appointment appointment = searchAppointment(id);
        appointmentRepo.delete(appointment);
    }
}
    