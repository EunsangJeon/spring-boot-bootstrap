package com.eunsang.spring.basic.firstspring;

import com.eunsang.spring.basic.firstspring.properties.SomeExternalService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan
@PropertySource("classpath:app.properties")
public class FirstSpringPropertiesApplication {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext applicationContext =
				new AnnotationConfigApplicationContext(FirstSpringPropertiesApplication.class);

		SomeExternalService service =
				applicationContext.getBean(SomeExternalService.class);

		System.out.println(service.returnServiceURL());
	}
}
