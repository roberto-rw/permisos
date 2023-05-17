
package com.example.permisos.controllers;

import com.example.permisos.entity.Permiso;
import com.example.permisos.services.PermisosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/permisos")
public class PermisosController {
    
    @Autowired
    private PermisosService permisoService;
    @PostMapping("/save")
    public ResponseEntity<Permiso> guardarPermiso(@RequestBody Permiso permiso){
        System.out.println("save permiso");
        Permiso permisoNuevo = permisoService.guardarPermiso(permiso);
        return new ResponseEntity<Permiso>(permisoNuevo, HttpStatus.OK);
    }
}
