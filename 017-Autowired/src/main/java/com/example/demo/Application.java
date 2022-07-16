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
		
		PeliculaService peliculaService = appContext.getBean(PeliculaService.class);
		
		peliculaService.pelisPorGenero("Drama").forEach(System.out::println);
				
		((ClassPathXmlApplicationContext) appContext).close();
	}

}
