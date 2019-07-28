package com.in28minutes.jpa.hibernate.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.in28minutes.jpa.hibernate.demo.entity.Course;
import com.in28minutes.jpa.hibernate.demo.repository.CourseRepository;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner{
	
	
	private static final Logger log = LoggerFactory.getLogger(DemoApplication.class);

	
	@Autowired
	CourseRepository repo;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Course course=repo.findById(10001L);
		log.info("course is {}",course);
		
		//delete
		repo.deleteByID(10001L);
		
		//insert the course
		repo.save(new Course("microservices"));
		
		//updates
		//repo.save(new Course("microservices"))
		
	}

}
