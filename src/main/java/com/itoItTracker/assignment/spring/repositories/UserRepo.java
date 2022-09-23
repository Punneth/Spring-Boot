package com.itoItTracker.assignment.spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.itoItTracker.assignment.spring.entity.User;

public interface UserRepo extends JpaRepository<User, Integer> {

	User findByEmailId(String emailId);
	@Query(value = "select user_id from user where user_email_id=:user_email_id",nativeQuery = true)
	Integer findIdByEmail(@Param(value="user_email_id") String user_email_id);

}
