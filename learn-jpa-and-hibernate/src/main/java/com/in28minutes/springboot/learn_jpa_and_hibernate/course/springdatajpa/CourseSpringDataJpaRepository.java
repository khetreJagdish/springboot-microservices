package com.in28minutes.springboot.learn_jpa_and_hibernate.course.springdatajpa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.in28minutes.springboot.learn_jpa_and_hibernate.course.Course;

public interface CourseSpringDataJpaRepository extends JpaRepository<Course, Long>{
	// you can define your custom methods
	List<Course> findByAuthor(String author);
	List<Course> findByName(String name);
}
