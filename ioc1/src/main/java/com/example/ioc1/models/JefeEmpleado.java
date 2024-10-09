package com.example.ioc1.models;

import com.example.ioc1.interfaces.Empleados;
import com.example.ioc1.interfaces.Informes;

public class JefeEmpleado implements Empleados {

    private final Informes informe;

    public JefeEmpleado(Informes informe) {
        this.informe = informe;
    }

    public String getTareas(){
        return "Gestiono cuestiones relativas a mis empleados";
    }

    @Override
    public String getInforme() {
        return "Informe del jefe empleado: " + informe.getInforme();
    }
}
