package com.eunsang.spring.basic.firstspring;

import com.eunsang.spring.basic.firstspring.xml.XMLPersonDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class FirstSpringXMLContextApplication {

	private static Logger LOGGER =
			LoggerFactory.getLogger(FirstSpringXMLContextApplication.class);

	public static void main(String[] args) {
		ClassPathXmlApplicationContext applicationContext =
				new ClassPathXmlApplicationContext("applicationContext.xml");

		LOGGER.info("Beans Loaded -> {}",
				(Object) applicationContext.getBeanDefinitionNames());

		XMLPersonDAO personDAO = applicationContext.getBean(XMLPersonDAO.class);

		LOGGER.info("{} {}", personDAO, personDAO.getXmlJdbcConnection());
	}
}
