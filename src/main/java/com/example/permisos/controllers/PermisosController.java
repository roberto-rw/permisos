/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.permisos.controllers;

import com.example.permisos.entity.Permiso;
import com.example.permisos.services.PermisosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author jegav
 */
@RestController
public class PermisosController {
    
    @Autowired
    private PermisosService permisoService;
    
    /**
     *
     * @param permiso
     * @return
     */
    @PostMapping("permisos/save")
    public ResponseEntity<Permiso> guardarPermiso(@RequestBody Permiso permiso){
        Permiso permisoNuevo = permisoService.guardarPermiso(permiso);
        System.out.println(permiso.getCedulaMedico());
        return new ResponseEntity<Permiso>(permisoNuevo, HttpStatusCode.valueOf(200)); 
    }
    
}
