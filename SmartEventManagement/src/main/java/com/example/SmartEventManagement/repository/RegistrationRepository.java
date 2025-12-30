package com.example.SmartEventManagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.SmartEventManagement.entity.Registration;

@Repository
public interface RegistrationRepository extends JpaRepository<Registration, Long> {
}
