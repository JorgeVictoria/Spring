package com.jovian.ioc01.models;

import com.jovian.ioc01.interfaces.Empleados;

public class Jefe implements Empleados {

    private Informe informe;

    public Jefe(Informe informe) {
        this.informe = informe;
    }

    @Override
    public String getTareas() {
        return "Gestiono las cuestiones relativas a mis empleados de sección.";
    }

    @Override
    public String getInforme() {
        return "Informe creado por el Jefe: " + informe.getInforme();
    }
}
