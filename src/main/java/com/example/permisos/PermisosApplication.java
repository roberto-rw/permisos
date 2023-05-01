package com.example.permisos;

import com.example.permisos.services.PermisosService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PermisosApplication {

	public static void main(String[] args) {
		SpringApplication.run(PermisosApplication.class, args);

//		try {
//			Thread.sleep(10000);
//		} catch (InterruptedException e) {
//			throw new RuntimeException(e);
//		}
//		PermisosService permisosService = new PermisosService();
//		System.out.println(permisosService.getPermiso("1234", 2L));
	}

}
