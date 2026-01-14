package com.appointments.app.appointments_app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.appointments.app.appointments_app")
public class AppointmentsAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(AppointmentsAppApplication.class, args);
    }
}
