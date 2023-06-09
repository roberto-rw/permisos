package com.example.permisos;

import com.example.permisos.repositories.PermisosRepository;
import com.example.permisos.services.PermisosService;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import java.io.IOException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class PermisosApplication {
  
	public static void main(String[] args) {
          
//            ConfigurableApplicationContext appContext = SpringApplication.run(PermisosApplication.class, args);
            //PermisosService perm = appContext.getBean(PermisosService.class);
            ConfigurableApplicationContext appContext = SpringApplication.run(PermisosApplication.class, args);
            PermisosRepository permisosRepository = appContext.getBean(PermisosRepository.class);
            PermisosService permisosService = new PermisosService(permisosRepository);

            Server server = ServerBuilder.forPort(9090).addService(permisosService).build();

            try {
                server.start();
                System.out.println("Se inicio el Server en el puerto 9090");
                server.awaitTermination();
            } catch (IOException | InterruptedException ex) {
                ex.printStackTrace();
            }
	}

}
