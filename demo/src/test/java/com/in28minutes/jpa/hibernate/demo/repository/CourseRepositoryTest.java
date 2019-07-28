package com.in28minutes.jpa.hibernate.demo.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import com.in28minutes.jpa.hibernate.demo.DemoApplication;
import com.in28minutes.jpa.hibernate.demo.entity.Course;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=DemoApplication.class)
public class CourseRepositoryTest {
	
	private static final Logger log = LoggerFactory.getLogger(CourseRepositoryTest.class);
	
	
	@Autowired
	CourseRepository repo;


	@Test
	public void findById() {
		log.info("Test is running");
		
		Course course=repo.findById(10002L);
		assertEquals("jpa into 50 steps", course.getName());
		
		
	}
	@Test
	@DirtiesContext //to reset data deleted
	public void testDelete() {
		
		Course course=repo.findById(10002L);
		assertNotNull(course);
		repo.deleteByID(10002L);
		assertNull(repo.findById(10002L));
	
		
	}
	
	@Test
	@DirtiesContext
	public void testInsert() {
		//insert
		assertNotNull(repo.save(new Course("java")));
		
		//update
		Course course=repo.findById(1L);
		assertNotNull(course);
		course.setName("just for test");
		assertEquals("just for test", repo.save(course).getName());
		
	}
	
}
