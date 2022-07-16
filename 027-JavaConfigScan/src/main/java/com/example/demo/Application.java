package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		
		SpringApplication.run(Application.class, args);
		
		ApplicationContext appContext = new AnnotationConfigApplicationContext(AppConfig.class);
		
		PeliculaService peliculaService = appContext.getBean(PeliculaService.class);
		
		peliculaService.pelisPorGenero("Ciencia ficción").forEach(System.out::println);
				
		((AnnotationConfigApplicationContext) appContext).close();
	}

}
