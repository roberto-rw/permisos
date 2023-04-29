package com.example.permisos.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Permiso {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    @Column( name = "id_permiso")
    private Long id;

    @Column(name = "cedula_medico")
    private String cedulaMedico;
    @Column(name = "id_paciente")
    private Long idPaciente;
}
