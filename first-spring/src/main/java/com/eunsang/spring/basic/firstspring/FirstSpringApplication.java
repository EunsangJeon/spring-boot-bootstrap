package com.eunsang.spring.basic.firstspring;

// import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FirstSpringApplication {

	public static void main(String[] args) {

		// #1
		// BinarySearchImpl binarySearchImpl = new BinarySearchImpl();

		// #2
		// BinarySearchImpl binarySearchImpl = new BinarySearchImpl(new BubbleSortAlgorithm());
		// You can (relatively) easily switch sorting algorithm
		BinarySearchImpl binarySearchImpl = new BinarySearchImpl(new BubbleSortAlgorithm());

		int result = binarySearchImpl.binarySearch(new int[] { 1, 2, 3, 4, 5 }, 3);
		System.out.println(result);

		// SpringApplication.run(FirstSpringApplication.class, args);
	}
}
