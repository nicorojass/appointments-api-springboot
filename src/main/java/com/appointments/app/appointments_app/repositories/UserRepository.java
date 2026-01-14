package com.appointments.app.appointments_app.repositories;

import org.springframework.data.repository.CrudRepository;

import com.appointments.app.appointments_app.models.User;

public interface UserRepository extends CrudRepository<User, Long>{

}
