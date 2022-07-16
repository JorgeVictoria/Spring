package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class InyeccionApplication {

	public static void main(String[] args) {
		
		//variables locales
		IEmailService emailService1 = null;
		IEmailService emailService2 = null;

		//inicio
		SpringApplication.run(InyeccionApplication.class, args);

		//abrimos el contexto con el fichero de nuestros beans, dentro de resources
		ApplicationContext appContext = new ClassPathXmlApplicationContext("beans.xml");

		//acceso a los bean

		//creamos el bean para el correo
		emailService1 = appContext.getBean(IEmailService.class);
		emailService2 = appContext.getBean(IEmailService.class);
		
		//vemos que hace referencia al mismo objeto
		System.out.println(emailService1);
		System.out.println(emailService2);
		
		//mandamos el correo
		emailService1.setDestinatarioPorDefecto("acme@acme.com");
		emailService1.enviarEmailSaludo();
		
		emailService2.enviarEmailSaludo();

		//cerramos el contexto
		((ClassPathXmlApplicationContext) appContext).close();
	
	}

}
