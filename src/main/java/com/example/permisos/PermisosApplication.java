package com.example.permisos;

import com.example.permisos.services.PermisosService;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class PermisosApplication {
  
	public static void main(String[] args) {
		ConfigurableApplicationContext appContext = SpringApplication.run(PermisosApplication.class, args);
                PermisosService perm = appContext.getBean(PermisosService.class);
                
                Server server = ServerBuilder.forPort(9090).addService(perm).build();
                
                try {
                    server.start();
                    System.out.println("Se inicio el Server en el puerto 9090");
                    server.awaitTermination();
                } catch (IOException | InterruptedException ex) {
                    ex.printStackTrace();
                }
                
                
	}

}
