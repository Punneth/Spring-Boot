package com.itoItTracker.assignment.spring.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.itoItTracker.assignment.spring.entity.Comments;
import com.itoItTracker.assignment.spring.entity.Ticket;
import com.itoItTracker.assignment.spring.entity.User;

public interface CommentsRepo extends JpaRepository<Comments, Integer> {
	
	List<Comments> findByTicket(Ticket ticket);
	
}
