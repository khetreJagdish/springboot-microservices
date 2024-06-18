package com.in28minutes.springboot.learn_jpa_and_hibernate.course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.in28minutes.springboot.learn_jpa_and_hibernate.course.jpa.CourseJpaRepository;
import com.in28minutes.springboot.learn_jpa_and_hibernate.course.springdatajpa.CourseSpringDataJpaRepository;

@Component
public class CourseCommandLineRunner implements CommandLineRunner {

	//@Autowired
	//private CourseJdbcRepository repository;
	
	//@Autowired
	//private CourseJpaRepository repository;
	
	@Autowired
	private CourseSpringDataJpaRepository repository;
	
	@Override
	public void run(String... args) throws Exception {
		
		// instead of insert, there is save in Spring Data JPA Repository 
		/*
		 * repository.insert(new Course(1, "Learn AWS Now!", "in28minutes"));
		 * repository.insert(new Course(2, "Learn AZURE Now!", "in28minutes"));
		 * repository.insert(new Course(3, "Learn DevOps Now!", "in28minutes"));
		 * repository.insert(new Course(4, "Learn Java Now!", "in28minutes"));
		 */
		
		repository.save(new Course(1, "Learn AWS Now!", "in28minutes"));
		repository.save(new Course(2, "Learn AZURE Now!", "in28minutes"));
		repository.save(new Course(3, "Learn DevOps Now!", "in28minutes"));
		repository.save(new Course(4, "Learn Java Now!", "in28minutes"));
		repository.deleteById(2L);
		System.out.println(repository.findById(1L));
		System.out.println(repository.findById(2L));
		System.out.println(repository.findById(3L));
		System.out.println(repository.findById(4L));
		
		System.out.println("Stream : ----------------");
		repository.findAll().stream().forEach(System.out::println);
		
		System.out.println(repository.findByAuthor("in28minutes"));
		System.out.println(repository.findByAuthor("in28minutes23"));
		
		System.out.println("Find By Name : "+repository.findByName("Learn Java Now!"));
	
	}

}
