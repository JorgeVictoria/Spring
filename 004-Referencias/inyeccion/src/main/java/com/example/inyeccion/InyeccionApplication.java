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
		EmailService emailService = null;

		//inicio
		SpringApplication.run(InyeccionApplication.class, args);

		//abrimos el contexto con el fichero de nuestros beans, dentro de resources
		ApplicationContext appContext = new ClassPathXmlApplicationContext("beans.xml");

		//acceso a los beans

		//creamos el bean con el mensaje de saludo. En este caso como no lo vamos a usar, no seria necesario
		saludador = (Saludator) appContext.getBean("saludator");

		//creamos el bean para el correo
		emailService = (EmailService) appContext.getBean("emailService");

		//mandamos el correo
		emailService.enviarEmailSaludo("acme@acme.com");

		//cerramos el contexto
		((ClassPathXmlApplicationContext) appContext).close();
	
	}

}
