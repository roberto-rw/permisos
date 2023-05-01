package com.example.permisos.repositories;

import com.example.permisos.entity.Permiso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Component
public interface PermisosRepository extends JpaRepository<Permiso, Long> {

    @Query("SELECT p FROM Permiso p WHERE p.cedulaMedico = :cedulaMedico AND p.idPaciente = :idPaciente")
    List<Permiso> findByCedulaMedicoAndIdPaciente(@Param("cedulaMedico") String cedulaMedico, @Param("idPaciente") Long idPaciente);
}
