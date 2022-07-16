package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class InyeccionApplication {

	public static void main(String[] args) {
		
		//variables locales. Usamos la interfaz
		IEmailService emailService = null;

		//inicio
		SpringApplication.run(InyeccionApplication.class, args);

		//abrimos el contexto con el fichero de nuestros beans, dentro de resources
		ApplicationContext appContext = new ClassPathXmlApplicationContext("beans.xml");

		//acceso a los bean

		//creamos el bean para el correo. Como solo hay una clase que implementa la interfaz, no hay problema
		emailService = appContext.getBean(IEmailService.class);

		//mandamos el correo
		emailService.enviarEmailSaludo("acme@acme.com");

		//cerramos el contexto
		((ClassPathXmlApplicationContext) appContext).close();
	
	}

}
