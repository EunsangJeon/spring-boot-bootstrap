package com.spring.jpa;

import com.spring.jpa.entity.Person;
import com.spring.jpa.springdata.PersonSpringDataRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

@SpringBootApplication
public class SpringDataDemoApplication implements CommandLineRunner {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	PersonSpringDataRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(SpringDataDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		logger.info("User Id 10001: {}", repository.findById(10001));

		logger.info("Insert 10010: {}", repository.save(
				new Person("Evil Abed", "Cafeteria", new Date())));

		logger.info("Update 10009: {}", repository.save(
				new Person(10009, "Senor Chang", "Classroom", new Date())));

		repository.deleteById(10007);

		logger.info("All users: {}", repository.findAll());
	}
}
