package com.itoItTracker.assignment.spring.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.itoItTracker.assignment.spring.entity.Ticket;

public interface TicketRepo extends JpaRepository<Ticket, Integer> {
	
	List<Ticket> findByReportedId(Integer userId);
	List<Ticket> findAllByReportedId(Integer userId);
	Integer findByAssigneeId(Integer assigneeId);
}
