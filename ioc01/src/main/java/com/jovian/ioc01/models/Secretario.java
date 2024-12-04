package com.jovian.ioc01.models;

import com.jovian.ioc01.interfaces.Empleados;

public class Secretario implements Empleados {

    private Informe informe;
    private String email;
    private String nombreEmpresa;

    public void setInforme(Informe informe) {
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

    @Override
    public String getTareas() {
        return "Gestiono la agenda de los Jefes";
    }

    @Override
    public String getInforme() {
        return "Informe creado por el Secretario: " + informe.getInforme();
    }
}
