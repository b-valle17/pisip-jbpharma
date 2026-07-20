package com.pisip.jbpharma.infraestructura.persistencia.jpa;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@Table(name = "rol")
public class RolEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_rol")
    private Integer idRol;

    @Column(name = "nombre_rol", nullable = false, unique = true, length = 80)
    private String nombreRol;

    @Column(name = "descripcion_rol", length = 255)
    private String descripcion;

    @OneToMany(mappedBy = "rol", fetch = FetchType.LAZY)
    @ToString.Exclude
    private List<UsuarioEntity> usuarios = new ArrayList<>();
}
