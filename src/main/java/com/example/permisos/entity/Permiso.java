package com.example.permisos.entity;

import javax.persistence.*;
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
    @Column(name = "nss_paciente")
    private String nss;
}
