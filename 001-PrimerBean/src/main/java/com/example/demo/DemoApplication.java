package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {

		//variables locales
		Saludator saludador = null;

		//inicio
		SpringApplication.run(DemoApplication.class, args);

		//abrimos el contexto con el fichero de nuestros beans, dentro de resources
		ApplicationContext appContext = new ClassPathXmlApplicationContext("beans.xml");
		
		//metodo alternativo para acceder al fichero bean con la ruta completa
		//ApplicationContext appContext = new FileSystemXmlApplicationContext("D:\\Spring\\demo\\src\\main\\resources\\beans.xml");

		//acceso a los beans
		//1. getBeans con Id y casting
		saludador = (Saludator) appContext.getBean("saludator");

		//2. getBean con id y clase
		//saludador = appContext.getBean("saludator", Saludator.class);

		//3. getBean con clase. La mas habitual
		//saludador = appContext.getBean(Saludator.class);

		//impresion por pantalla
		System.out.println(saludador.saludo());

		//cerramos el contexto
		((ClassPathXmlApplicationContext) appContext).close();
		//((FileSystemXmlApplicationContext) appContext).close();
	}

}
