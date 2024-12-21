package org.usermanagementservice.usermanagementservice.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.usermanagementservice.usermanagementservice.enumeration.RoleName;
import org.usermanagementservice.usermanagementservice.model.Role;
import org.usermanagementservice.usermanagementservice.model.Customer;
import org.usermanagementservice.usermanagementservice.repository.RoleRepo;
import org.usermanagementservice.usermanagementservice.repository.CustomerRepo;

import java.util.HashSet;

@Service
public class CustomerService {
    private final KafkaProducerService kafkaProducerService;
    private final CustomerRepo userRepo;
    private final RoleRepo roleRepo;
    private final PasswordEncoder passwordEncoder;

    public CustomerService(KafkaProducerService kafkaProducerService, CustomerRepo userRepo, RoleRepo roleRepo, PasswordEncoder passwordEncoder) {
        this.kafkaProducerService = kafkaProducerService;
        this.userRepo = userRepo;
        this.roleRepo = roleRepo;
        this.passwordEncoder = passwordEncoder;
    }

    public void registerUser(Customer customer, RoleName roleName) {
        if(userRepo.existsByUsername(customer.getUsername()) || userRepo.existsByEmail(customer.getEmail())) {
            throw new RuntimeException("Username already exists");
        }
        Role role = roleRepo.findByName(roleName)
                .orElseThrow(() -> new RuntimeException("Role not found!"));

        customer.setRoles(new HashSet<>());
        customer.getRoles().add(role);
        customer.setPassword(passwordEncoder.encode(customer.getPassword()));
        userRepo.save(customer);

        String userEvent = "{\"eventType\": \"USER_REGISTERED\", \"userId\": \"" + customer.getId() + "\", \"email\": \"" + customer.getEmail() + "\"}";

        // Send the event to Kafka
        kafkaProducerService.sendUserEvent(customer.getId(), userEvent);

    }
}
