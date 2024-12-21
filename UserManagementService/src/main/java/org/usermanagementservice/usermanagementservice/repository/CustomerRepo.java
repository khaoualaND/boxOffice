package org.usermanagementservice.usermanagementservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.usermanagementservice.usermanagementservice.model.Customer;

import java.util.Optional;

public interface CustomerRepo extends JpaRepository<Customer, Integer> {
    Optional<Customer> findByUsername(String username);
    boolean existsByEmail(String email);
    boolean existsByUsername(String username);
}
