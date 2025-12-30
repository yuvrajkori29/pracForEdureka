package com.example.SmartEventManagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.SmartEventManagement.entity.Attendee;

@Repository
public interface AttendeeRepository extends JpaRepository<Attendee, Long> {
}
