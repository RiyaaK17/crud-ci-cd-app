package com.example.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.project.entities.Course;

public interface CourseRepository extends JpaRepository<Course,Long> {
	
}
