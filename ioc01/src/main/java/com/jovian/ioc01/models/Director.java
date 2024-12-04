package com.jovian.ioc01.models;

import com.jovian.ioc01.interfaces.Empleados;

public class Director implements Empleados {

    private Informe informe;
    private String email;
    private String nombreEmpresa;

    Director(Informe informe){
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
        return "Gestiono la plantilla de la empresa";
    }

    @Override
    public String getInforme() {
        return "Informe creado por el Director: " + informe.getInforme();
    }

    //crear método init, crear tareas antes de que el bean esté disponible
    public void metodoInicial(){
        System.out.println("Dentro del método init.");
    }

    //crear método destroy, crear tareas después de que el bean haya sido utilizado
    public void metodoFinal(){
        System.out.println("Dentro del método destroy");
    }
}
