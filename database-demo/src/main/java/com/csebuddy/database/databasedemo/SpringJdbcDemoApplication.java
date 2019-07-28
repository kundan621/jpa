package com.csebuddy.database.databasedemo;

import java.util.Date;

import org.hibernate.service.spi.InjectService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.csebuddy.database.databasedemo.entity.Person;
import com.csebuddy.database.databasedemo.jdbc.PersonJdbcDao;

   
//@SpringBootApplication
public class SpringJdbcDemoApplication implements CommandLineRunner
{
	
	private static final Logger log = LoggerFactory.getLogger(SpringJdbcDemoApplication.class);

    @Autowired
	PersonJdbcDao dao;
	public static void main(String[] args) {
		SpringApplication.run(SpringJdbcDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		log.info("All users -> {}",dao.findAll());
		
		log.info("one user -> {}",dao.findById(10001));
		
		log.info("deleting 10002 user -> {}",dao.DeleteById(10002));
		
		log.info("inserting 10004 ->{}",dao.Insert(new Person(10004,"tara","berlin",new Date())));
		
		log.info("update 10003 ->{}",dao.Update(new Person(10003,"changedname","berlin",new Date())));
	}

}
