package com.example.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Saludator {
	
	@Value("${mensaje}")
	private String mensaje;
	
	public String saludo() {
		return mensaje;
	}

}
