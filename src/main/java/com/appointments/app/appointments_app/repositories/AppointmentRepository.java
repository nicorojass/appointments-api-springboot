package com.appointments.app.appointments_app.repositories;

import java.time.LocalDate;
import java.time.LocalTime;

import org.springframework.data.repository.CrudRepository;

import com.appointments.app.appointments_app.models.Appointment;
import com.appointments.app.appointments_app.models.Status;


public interface AppointmentRepository extends CrudRepository<Appointment, Long> {

    boolean existsByDateAndTimeAndStatus(LocalDate date, LocalTime time, Status status);
}
