package com.spring.database;

import com.spring.database.entity.Person;
import com.spring.database.jdbc.PersonJdbcDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

@SpringBootApplication
public class DatabaseApplication implements CommandLineRunner {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	PersonJdbcDAO dao;

	public static void main(String[] args) {

		SpringApplication.run(DatabaseApplication.class, args);

	}

	@Override
	public void run(String... args) throws Exception {

		logger.info("Community main characters: {}", dao.findAll());

		logger.info("User id 10001: {}", dao.findById(10001));

		logger.info("Deleted id 10009: {} rows deleted", dao.deleteById(10009));

		logger.info("Inserted 10010: {}",
				dao.insert(new Person(10010, "Buzz Hickey", "Faculty Room", new Date())));

		logger.info("Updated 10008: {}",
				dao.update(new Person(10008, "Dean Craig", "Broadcast Room", new Date())));
	}

}
