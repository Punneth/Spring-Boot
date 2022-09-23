package com.itoItTracker.assignment.spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.itoItTracker.assignment.spring.entity.Category;

public interface CategoryRepo extends JpaRepository<Category, Integer>{

}
