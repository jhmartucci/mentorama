package com.mentorama.modulo09.parkingcontrol;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class ParkingControlApplication {
	public static void main(String[] args) {
		SpringApplication.run(ParkingControlApplication.class, args);
	}
}
