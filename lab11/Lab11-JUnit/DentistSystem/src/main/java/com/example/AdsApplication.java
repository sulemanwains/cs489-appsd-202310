package com.example;

import com.example.Service.AppointmentService;
import com.example.Service.DentistService;
import com.example.Service.Impl.AppointmentServiceImpl;
import com.example.Service.PatientService;
import com.example.entity.Address;
import com.example.entity.Appointments;
import com.example.entity.Dentist;
import com.example.entity.Patient;
import com.example.entity.Role;
import com.example.entity.User;
import com.example.repo.RoleRepository;
import com.example.repo.UserRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class AdsApplication implements Runnable {

	private UserRepository userRepository;
	private RoleRepository roleRepository;
	private PasswordEncoder passwordEncoder;
	public AdsApplication(UserRepository userRepository,
						  RoleRepository roleRepository,
						  PasswordEncoder passwordEncoder) {
		this.userRepository = userRepository;
		this.roleRepository = roleRepository;
		this.passwordEncoder = passwordEncoder;
	}
	public static void main(String[] args) {
		SpringApplication.run(AdsApplication.class, args);
	}

	@Override
	public void run() {
	}

	@PostConstruct
	public void initAdminUser() {
		System.out.println("RUN***");
		var adminUser = userRepository.findByUsername("admin");
		if(adminUser.isEmpty()) {
			List<Role> listAdminRoles = new ArrayList<>();
			var adminRole = roleRepository.findByRole("ADMIN");
			if(adminRole.isEmpty()) {
				var newAdminRole =  new Role("ADMIN");
				listAdminRoles.add(newAdminRole);
			} else {
				listAdminRoles.add(adminRole.get());
			}
			User newAdminUser = new User("admin", "admin@ads.com",
					passwordEncoder.encode("test1234"),
					true,true, true, true);
			newAdminUser.setRoles(listAdminRoles);
			userRepository.save(newAdminUser);
		}
	}
}
