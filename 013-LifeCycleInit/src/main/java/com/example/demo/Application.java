package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		
		SpringApplication.run(Application.class, args);
		
		ApplicationContext appContext = new ClassPathXmlApplicationContext("beans.xml");
		
		PersonaDAO personaDAO = appContext.getBean(PersonaDAO.class);
		
		personaDAO.findAll().forEach(System.out::println);
		
		((ClassPathXmlApplicationContext) appContext).close();
	}

}
