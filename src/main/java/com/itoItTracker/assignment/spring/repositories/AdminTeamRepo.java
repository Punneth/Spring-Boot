package com.itoItTracker.assignment.spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.itoItTracker.assignment.spring.entity.AdminTeam;

public interface AdminTeamRepo extends JpaRepository<AdminTeam, Integer> {

}
