package com.in28minutes.jpa.hibernate.demo.repository;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.in28minutes.jpa.hibernate.demo.entity.Course;

@Repository
@Transactional
public class CourseRepository {

	@Autowired
	EntityManager em;
	
	/**
	 * To find the course by id
	 * @param id unique id
	 * @return course
	 */
	public Course findById(Long id) {
		
		return em.find(Course.class, id);
	}
	
	
	/**
	 * To save a course
	 * @param course to be saved
	 * @return course saved
	 */
	public Course save(Course course) {
		//persist is used to insert
		if(course.getId()==null) {
			em.persist(course);
		}
		///merge for update
		else {
			em.merge(course);
		}
		
		return course;
	}
	
	/**
	 * Remove the course of particular id
	 * @param id id
	 */
	public void deleteByID(Long id) {
		
		
		em.remove(findById(id));
		}
	
}
