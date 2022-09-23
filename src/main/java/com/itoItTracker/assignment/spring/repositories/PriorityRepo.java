package com.itoItTracker.assignment.spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.itoItTracker.assignment.spring.entity.Priority;

public interface PriorityRepo extends JpaRepository<Priority, Integer> {

}
