package com.pisip.jbpharma.infraestructura.persistencia.jpa;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@Table(name = "usuario")
public class UsuarioEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private Integer idUsuario;

    @Column(name = "nombre_usuario", nullable = false, length = 120)
    private String nombre;

    @Column(name = "correo_usuario", nullable = false, unique = true, length = 150)
    private String correo;

    @Column(name = "contrasena_hash", nullable = false, length = 255)
    private String contrasenaHash;

    @Column(name = "estado_usuario", nullable = false)
    private Boolean estadoUsuario = true;

    @Column(name = "fecha_creacion", nullable = false)
    private LocalDateTime fechaCreacion = LocalDateTime.now();
    
    @Column(name = "id_rol")
	private Integer idRol;

    @ManyToOne
	@JoinColumn(name = "id_rol", insertable = false, updatable = false)
    private RolEntity rol;

    @OneToMany(mappedBy = "usuario", fetch = FetchType.LAZY)
    @ToString.Exclude
    private List<PlanProduccionEntity> planesProduccion = new ArrayList<>();

    @OneToMany(mappedBy = "usuario", fetch = FetchType.LAZY)
    @ToString.Exclude
    private List<OrdenProduccionEntity> ordenesProduccion = new ArrayList<>();

    @OneToMany(mappedBy = "usuarioAuditor", fetch = FetchType.LAZY)
    @ToString.Exclude
    private List<AuditoriaLoteEntity> auditoriasRealizadas = new ArrayList<>();

    @OneToMany(mappedBy = "usuarioInspector", fetch = FetchType.LAZY)
    @ToString.Exclude
    private List<DictamenLoteEntity> dictamenesRealizados = new ArrayList<>();
}
