package com.example.ioc1;

import com.example.ioc1.interfaces.Empleados;
import com.example.ioc1.models.DirectorEmpleado;
import com.example.ioc1.models.SecretarioEmpleado;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class App {

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);

        //Creación de objetos de tipo empleado con Spring
        //Solo debemos cambiar la clase a usar en el fichero xml
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        Empleados empleado = context.getBean("miEmpleado", Empleados.class);
        //En este caso queremos utilizar todos los métodos de la clase secretario y no solo los de la interfaz empleados
        SecretarioEmpleado secretario = context.getBean("miSecretario", SecretarioEmpleado.class);
        SecretarioEmpleado secretario2 = context.getBean("miSecretario", SecretarioEmpleado.class);
        DirectorEmpleado director = context.getBean("miDirector", DirectorEmpleado.class);

        //Uso de objetos de tipo empleado
        System.out.println(empleado.getTareas());
        System.out.println(empleado.getInforme());
        System.out.println(secretario.getInforme());
        System.out.println("Email:" + secretario.getEmail());
        System.out.println("Empresa:" + secretario.getNombreEmpresa());
        System.out.println(director.getInforme());
        System.out.println("Email:" + director.getEmail());
        System.out.println("Empresa:" + director.getNombreEmpresa());

        System.out.println("----------------");
        System.out.println("Patrón singleton");
        System.out.println("----------------");
        System.out.println(secretario);
        System.out.println(secretario2);
        if(secretario==secretario2){
            System.out.println("Apuntan al mismo objeto");
        }
        else{
            System.out.println("Apuntan a diferentes objetos");
        }


        //cerrar el contexto
        context.close();

    }

}
