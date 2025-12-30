package com.example.SmartEventManagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.SmartEventManagement.entity.Event;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {
}
