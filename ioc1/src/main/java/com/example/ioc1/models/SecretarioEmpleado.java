package com.example.ioc1.models;

import com.example.ioc1.interfaces.Empleados;

public class SecretarioEmpleado implements Empleados {


    @Override
    public String getTareas() {
        return "Gestiono la agenda de mis jefes.";
    }
}
