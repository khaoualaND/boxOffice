package org.usermanagementservice.usermanagementservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.usermanagementservice.usermanagementservice.enumeration.RoleName;
import org.usermanagementservice.usermanagementservice.model.Role;

import java.util.Optional;

public interface RoleRepo extends JpaRepository<Role, Integer> {
    Optional<Role> findByName(RoleName name);
}
