package com.company.employeemanagementrestapi.data.repository;

import com.company.employeemanagementrestapi.data.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.swing.text.html.Option;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {
    Optional<User> findByEmailOrUsername(String email, String username);
    Boolean existsByEmail(String email);
    Boolean existsByUsername(String username);
    User findByActivationCode(String activationCode);
    Optional<User> findByEmail(String email);

    User getByEmail(String email);

    Optional<User> findBySixDigitCode(String sixDigitCode);
}
