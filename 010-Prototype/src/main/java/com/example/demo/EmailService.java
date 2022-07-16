package com.example.demo;

public class EmailService implements IEmailService {

    //atributos
    private Saludator saludator;
    private String destinatarioPorDefecto;

    //setter. Referenciamos al bean saludator
    public void setSaludator(Saludator saludator){
        this.saludator = saludator;
    }
    
    
    //setter para introducir un usuario por defecto
    public void setDestinatarioPorDefecto(String destinatario) {
		this.destinatarioPorDefecto = destinatario;
	}


	//metodos para enviar un correo
    public void enviarEmailSaludo() {
    	if(destinatarioPorDefecto != null) enviarEmailSaludo(destinatarioPorDefecto);
    	else System.out.println("Configure un usuario destinatario.");
    }
    
    public void enviarEmailSaludo(String destinatario){
        System.out.println("Enviando email a " + destinatario);
        System.out.println("Mensaje: " + saludator.saludo());
    }
    
}
