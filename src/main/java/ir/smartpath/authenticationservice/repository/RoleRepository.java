package ir.smartpath.authenticationservice.repository;


import java.util.Optional;

import ir.smartpath.authenticationservice.models.ERole;
import ir.smartpath.authenticationservice.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(ERole name);
}

