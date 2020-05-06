package com.nick.springboot.basic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class BasicApplication {

	public static void main(String[] args) {

		ApplicationContext applicationContext =
				SpringApplication.run(BasicApplication.class, args);

		for (String name: applicationContext.getBeanDefinitionNames()) {
			System.out.println(name);
		}
	}

}
