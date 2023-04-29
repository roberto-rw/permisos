package com.example.permisos.services;

import com.example.permisos.entity.Permiso;
import com.example.permisos.repositories.PermisosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PermisosService {

    @Autowired
    private PermisosRepository permisosRepository;


//    public Permiso createPermiso(){
//
//    }

    public boolean getPermiso(String cedulaMedico, Long idPaciente){
        List<Permiso> permisos = permisosRepository.findByCedulaMedicoAndIdPaciente(cedulaMedico, idPaciente);
        if(permisos.isEmpty()) return false;
        return true;
    }


}
