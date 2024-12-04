package com.jovian.ioc01.models;

import com.jovian.ioc01.interfaces.Informes;

public class Informe implements Informes {

    @Override
    public String getInforme() {
        return "Esta es la presentación del informe";
    }

}
