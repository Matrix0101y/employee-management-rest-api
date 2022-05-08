package com.company.employeemanagementrestapi.data.repository;

import com.company.employeemanagementrestapi.data.entity.UserStatus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserStatusRepositry extends JpaRepository<UserStatus,Long> {
    UserStatus findUserStatusById(Long id);
}
