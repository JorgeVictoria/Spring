package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		
		SpringApplication.run(Application.class, args);
		
		ApplicationContext appContext = new AnnotationConfigApplicationContext(AppConfig.class);
		
		Saludator saludator = appContext.getBean(Saludator.class);
		
		System.out.println(saludator.saludo());
		
		((AnnotationConfigApplicationContext)appContext).close();
	}

}
