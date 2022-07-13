package com.example.inyeccion;

public class Saludator {

    //variables miembro
    private String mensaje;

    //setter
    public void setMensaje(String msg){
        this.mensaje = msg;
    }

    //metodo que devuelve un saludo
    public String saludo(){
        
        return(mensaje == null) ? "Hola mundo!!!" : mensaje;
        
    }
    
}
