package com.example.ioc1.models;

import com.example.ioc1.interfaces.Empleados;

public class DirectorEmpleado implements Empleados {
    @Override
    public String getTareas() {
        return "Gestiono la plantilla de la empresa";
    }
}
