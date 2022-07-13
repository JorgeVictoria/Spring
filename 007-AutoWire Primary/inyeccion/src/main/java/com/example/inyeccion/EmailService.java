package com.example.inyeccion;

public class EmailService implements IEmailService {

    //variables miembro
    private Saludator saludator;

    //setter
    public void setSaludator(Saludator saludator){
        this.saludator = saludator;
    }

    //metodo para enviar un correo
    public void enviarEmailSaludo(String destinatario){
        System.out.println("Enviando email a " + destinatario);
        System.out.println("Mensaje: " + saludator.saludo());
    }
    
}
