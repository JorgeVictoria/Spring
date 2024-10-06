package com.example.ioc1;

import com.example.ioc1.interfaces.Empleados;
import com.example.ioc1.models.DirectorEmpleado;
import com.example.ioc1.models.JefeEmpleado;
import com.example.ioc1.models.SecretarioEmpleado;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class App {

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);

        //Creación de objetos de tipo empleado clásica
        //JefeEmpleado empleado = new JefeEmpleado();

        //Creación de objetos de tipo empleado con interfaces
        //Si queremos usar un objeto concreto, debemos realizar el cambio en código
        //Empleados empleado = new JefeEmpleado();
        //Empleados empleado = new SecretarioEmpleado();
        //Empleados empleado = new DirectorEmpleado();

        //Creación de objetos de tipo empleado con Spring
        //Solo debemos cambiar la clase a usar en el fichero xml
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        Empleados empleado = context.getBean("miEmpleado", Empleados.class);

        //Uso de objetos de tipo empleado
        System.out.println(empleado.getTareas());

        //cerrar el contexto
        context.close();

    }

}
