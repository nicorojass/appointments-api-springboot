package com.appointments.app.appointments_app.repositories;

import org.springframework.data.repository.CrudRepository;

import com.appointments.app.appointments_app.models.Appointment;

public interface AppointmentRepository extends CrudRepository<Appointment, Long> {

}
