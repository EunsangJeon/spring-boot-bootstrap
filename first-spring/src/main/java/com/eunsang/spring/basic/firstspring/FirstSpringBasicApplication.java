package com.eunsang.spring.basic.firstspring;

import com.eunsang.spring.basic.firstspring.basic.BinarySearchImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
public class FirstSpringBasicApplication {

	public static void main(String[] args) {

		AnnotationConfigApplicationContext applicationContext =
				new AnnotationConfigApplicationContext(FirstSpringBasicApplication.class);

		BinarySearchImpl binarySearch = applicationContext.getBean(BinarySearchImpl.class);

		int result = binarySearch.binarySearch(new int[] { 1, 2, 3, 4, 5 }, 3);
		System.out.println(result);

		applicationContext.close();
	}
}
