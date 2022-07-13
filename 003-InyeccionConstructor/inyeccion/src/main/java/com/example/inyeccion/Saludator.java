package com.example.inyeccion;

public class Saludator {

    //variables miembro
    private String mensaje;

    //constructores
    public Saludator(){}
    
    public Saludator(String str) {
        this.mensaje = str;
    }

    //setter
    public void setMensaje(String msg){
        this.mensaje = msg;
    }

    //getter
    public String getSaludo(){
        
        return(mensaje == null) ? "Hola mundo!!!" : mensaje;
        
    }
    
}
