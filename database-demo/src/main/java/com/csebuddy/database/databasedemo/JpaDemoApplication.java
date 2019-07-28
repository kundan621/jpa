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
import com.csebuddy.database.databasedemo.jpa.PersonJpaRepository;

   
@SpringBootApplication
public class JpaDemoApplication implements CommandLineRunner
{
	
	private static final Logger log = LoggerFactory.getLogger(JpaDemoApplication.class);

    @Autowired
	PersonJpaRepository jpaRepository;
	public static void main(String[] args) {
		SpringApplication.run(JpaDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
log.info("All users -> {}",jpaRepository.findAll());
		
		log.info("one user -> {}",jpaRepository.findById(10001));
		
		jpaRepository.deleteById(10002);
//		
        log.info("inserting 10004 ->{}",jpaRepository.insert(new Person(10004,"tara","berlin",new Date())));
//		
		log.info("update 10003 ->{}",jpaRepository.update(new Person(10003,"changedname","berlin",new Date())));
//
		}

}
