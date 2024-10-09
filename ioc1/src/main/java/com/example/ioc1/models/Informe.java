package com.example.ioc1.models;

import com.example.ioc1.interfaces.Informes;

public class Informe implements Informes {

    @Override
    public String getInforme() {
        return "Informe nuevo.";
    }
}
