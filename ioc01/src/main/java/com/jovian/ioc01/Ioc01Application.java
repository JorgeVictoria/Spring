package com.jovian.ioc01;

import com.jovian.ioc01.interfaces.Empleados;
import com.jovian.ioc01.models.Director;
import com.jovian.ioc01.models.Secretario;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class Ioc01Application {

    public static void main(String[] args) {
        SpringApplication.run(Ioc01Application.class, args);

        //Creación típica de objetos de tipo empleado
        //Empleados empleado01 = new Director();

        //Creación del contexto
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        //Pedir al fichero xml el bean
        Empleados jefe = context.getBean("miJefe", Empleados.class);

        //En este caso como queremos utilizar más métodos que los que nos proporciona la interfaz empleados
        //debemos utilizar la clase Secretario
        Secretario secretario = context.getBean("miSecretario", Secretario.class);
        Secretario secretarioB = context.getBean("miSecretario", Secretario.class);
        Director director = context.getBean("miDirector", Director.class);

        //Uso de objetos de tipo empleado
//        System.out.println();
//        System.out.println(jefe.getTareas());
//        System.out.println(jefe.getInforme());
//        System.out.println();
//
//        System.out.println(secretario.getTareas());
//        System.out.println(secretario.getInforme());
//        System.out.println(secretario.getNombreEmpresa());
//        System.out.println(secretario.getEmail());
//        System.out.println();
//
        System.out.println(director.getTareas());
        System.out.println(director.getInforme());
        System.out.println(director.getNombreEmpresa());
        System.out.println(director.getEmail());

        //uso de patron singleton o prototype (propiedad scope)
//        System.out.println();
//        System.out.println(secretario);
//        System.out.println(secretarioB);
//        if(secretario==secretarioB){
//            System.out.println("Son el mismo objeto");
//        } else {
//            System.out.println("No son el mismo objeto");
//        }

        //Cerrar el contexto
        context.close();
    }

}
