package com.eunsang.spring.basic.firstspring;

import com.eunsang.spring.basic.firstspring.basic.BinarySearchImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication // This tells Sprint to search beans within the package it belongs to.
public class FirstSpringBasicApplication {

	public static void main(String[] args) {

		// #1
		// BinarySearchImpl binarySearchImpl = new BinarySearchImpl();

		// #2
		// BinarySearchImpl binarySearchImpl = new BinarySearchImpl(new BubbleSortAlgorithm());
		// You can (relatively) easily switch sorting algorithm
		// BinarySearchImpl binarySearchImpl = new BinarySearchImpl(new BubbleSortAlgorithm());
		// int result = binarySearchImpl.binarySearch(new int[] { 1, 2, 3, 4, 5 }, 3);
		// System.out.println(result);

		// #3 Application Context
		ApplicationContext applicationContext =
				SpringApplication.run(FirstSpringBasicApplication.class, args);

		BinarySearchImpl binarySearch = applicationContext.getBean(BinarySearchImpl.class);

		int result = binarySearch.binarySearch(new int[] { 1, 2, 3, 4, 5 }, 3);
		System.out.println(result);
	}
}
