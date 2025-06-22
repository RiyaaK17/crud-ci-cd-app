package com.example.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.project.entities.Course;
import com.example.project.repository.CourseRepository;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:3000")
public class CourseController {
	
	@Autowired
	CourseRepository repo;
	@GetMapping("/courses")
	public List<Course> getAllCourses(){
		repo.findAll();
		List<Course> courses = repo.findAll();
		
		return courses;
	}
	
    @GetMapping("/courses/{id}")
    public Course getCourse(@PathVariable long id) {
    	Course course=repo.findById(id).get();
    	return course;
	}
    
    @PostMapping("/courses/add")
    @ResponseStatus(code= HttpStatus.CREATED)
    public void createcourse(@RequestBody Course course) {
    	repo.save(course);
    }
    
    @PutMapping("/courses/{id}")
    public Course updatecourse(@PathVariable long id) {
    	Course course=repo.findById(id).get();
    	course.setTitle("Java");
    	course.setDescription("This is java course");
    	repo.save(course);
    	return course;
    	
    }
    
    @DeleteMapping("/courses/delete/{id}")
    public void deletecourse(@PathVariable long id) {
    	Course course=repo.findById(id).get();
    	repo.delete(course);
    	
    }
}
