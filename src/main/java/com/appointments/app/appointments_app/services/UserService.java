package com.appointments.app.appointments_app.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.appointments.app.appointments_app.models.User;
import com.appointments.app.appointments_app.repositories.UserRepository;

@Service
public class UserService {
    private final UserRepository userRepo;

    public UserService(UserRepository userRepo) {
        this.userRepo = userRepo;
    }

    public User createUser(User newUser){
        return userRepo.save(newUser);
    }

    public User searchUser(Long id){
        return userRepo.findById(id).orElseThrow(() -> new IllegalArgumentException("No existe un turno con ese ID"));
    }

    public List<User> getAllUsers() {
        return (List<User>) userRepo.findAll();
}
    
}
