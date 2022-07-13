package com.example.inyeccion;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class InyeccionApplication {

	public static void main(String[] args) {
		
		//variables locales
		Saludator saludador = null;

		//inicio
		SpringApplication.run(InyeccionApplication.class, args);

		//abrimos el contexto con el fichero de nuestros beans, dentro de resources
		ApplicationContext appContext = new ClassPathXmlApplicationContext("beans.xml");

		//acceso a los beans
		saludador = (Saludator) appContext.getBean("saludator");

		//impresion por pantalla
		System.out.println(saludador.getSaludo());

		//cerramos el contexto
		((ClassPathXmlApplicationContext) appContext).close();
	
	}

}
