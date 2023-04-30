package com.example.permisos.services;

import com.example.permisos.entity.Permiso;
import com.example.permisos.repositories.PermisosRepository;
import com.permisosservicegrpc.grpc.PermisoRequest;
import com.permisosservicegrpc.grpc.PermisoResponse;
import com.permisosservicegrpc.grpc.permisosServiceGrpc.permisosServiceImplBase;
import io.grpc.stub.StreamObserver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PermisosService extends permisosServiceImplBase{

    @Autowired
    private PermisosRepository permisosRepository;
//    public Permiso createPermiso(){
//
//    }
    
    public Permiso guardarPermiso(Permiso permiso){
        return permisosRepository.save(permiso);
    }

    @Override
    public void getPermiso(PermisoRequest request, StreamObserver<PermisoResponse> responseObserver) {
        List<Permiso> permisos = permisosRepository.findByCedulaMedicoAndIdPaciente(request.getCedulaMedico(), request.getIdPaciente());
        PermisoResponse.Builder response = PermisoResponse.newBuilder();
        if(permisos.isEmpty()){
            response.setPermiso(false);
        } else{
            response.setPermiso(true);
        }
        responseObserver.onNext(response.build());
        responseObserver.onCompleted();
    }
    
    


}
