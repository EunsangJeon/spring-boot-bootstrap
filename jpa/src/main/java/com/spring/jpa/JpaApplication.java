package com.spring.jpa;

import com.spring.jpa.entity.Person;
import com.spring.jpa.jpa.PersonJpaRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

@SpringBootApplication
public class JpaApplication implements CommandLineRunner {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	PersonJpaRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(JpaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		logger.info("User Id 10001: {}", repository.findbyId(10001));

		logger.info("Insert 10010: {}", repository.insert(
				new Person("Evil Abed", "Cafeteria", new Date())));

		logger.info("Update 10009: {}", repository.update(
				new Person(10009, "Senor Chang", "Classroom", new Date())));

		repository.deleteById(10007);
	}
}
