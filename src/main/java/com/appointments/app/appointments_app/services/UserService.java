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
        
        if (userRepo.existsByDni(newUser.getDni())){
            throw new IllegalArgumentException("Ya existe un usuario con ese DNI");
        }

        return userRepo.save(newUser);
    }

    public User searchUser(Long id){
        return userRepo.findById(id).orElseThrow(() -> new IllegalArgumentException("No existe un usuario con ese ID"));
    }

    public List<User> getAllUsers() {
        return (List<User>) userRepo.findAll();
    }
    
    public void deleteUser(Long id){
        User user = searchUser(id);
        userRepo.delete(user);
    }

}
