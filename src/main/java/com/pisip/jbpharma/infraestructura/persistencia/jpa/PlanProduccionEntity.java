package com.pisip.jbpharma.infraestructura.persistencia.jpa;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@Table(name = "plan_produccion")
public class PlanProduccionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_plan")
    private Integer idPlan;

    @Column(name = "codigo_plan", nullable = false, unique = true, length = 30)
    private String codigoPlan;

    @Column(nullable = false)
    private Integer mes;

    @Column(nullable = false)
    private Integer anio;

    @Column(name = "fecha_emision", nullable = false)
    private LocalDate fechaEmision;

    @Column(nullable = false, length = 30)
    private String estado;

    @Column(length = 255)
    private String descripcion;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "fk_usuario", nullable = false)
    @ToString.Exclude
    private UsuarioEntity usuarioResponsable;

    @OneToMany(mappedBy = "planProduccion", fetch = FetchType.LAZY)
    @ToString.Exclude
    private List<OrdenProduccionEntity> ordenesProduccion = new ArrayList<>();
}
