package com.example.ioc1.models;

import com.example.ioc1.interfaces.Empleados;

public class JefeEmpleado implements Empleados {

    public String getTareas(){
        return "Gestiono cuestiones relativas a mis empleados";
    }
}
