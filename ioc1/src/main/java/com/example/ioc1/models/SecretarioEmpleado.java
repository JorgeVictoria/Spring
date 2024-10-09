package com.example.ioc1.models;

import com.example.ioc1.interfaces.Empleados;
import com.example.ioc1.interfaces.Informes;

public class SecretarioEmpleado implements Empleados {

    private Informes informe;
    private String email;
    private String nombreEmpresa;

    @Override
    public String getTareas() {
        return "Gestiono la agenda de mis jefes.";
    }

    @Override
    public String getInforme() {
        return "Informe del secretario empleado: " + informe.getInforme();
    }

    public void setInforme(Informes informe) {
        this.informe = informe;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }
}
