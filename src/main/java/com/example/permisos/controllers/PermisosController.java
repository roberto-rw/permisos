package com.example.permisos.controllers;


import com.example.permisos.repositories.PermisosRepository;
import com.example.permisos.services.PermisosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PermisosController {


    @Autowired
    PermisosService permisosService;

    @RequestMapping(value = "/permisos/prueba")
    public String metodoPrueba(){
        boolean response = permisosService.getPermiso("1234", 2L);
        System.out.println(response);
        return "Funciona el jpa";
    }
}
