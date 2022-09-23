package com.itoItTracker.assignment.spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.itoItTracker.assignment.spring.entity.Status;

public interface StatusRepo extends JpaRepository<Status, Integer> {

}
