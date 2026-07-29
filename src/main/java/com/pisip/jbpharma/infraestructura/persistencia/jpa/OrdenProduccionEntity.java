package com.pisip.jbpharma.infraestructura.persistencia.jpa;

import java.math.BigDecimal;
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
@Table(name = "orden_produccion")
public class OrdenProduccionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_orden")
    private Integer idOrden;

    @Column(name = "numero_lote", nullable = false, unique = true, length = 10)
    private String numeroLote;

    @Column(name = "cantidad_lote", nullable = false, precision = 12, scale = 3)
    private BigDecimal cantidadLote;

    @Column(name = "fecha_inicio")
    private LocalDateTime fechaInicio = LocalDateTime.now();

    @Column(name = "fecha_final")
    private LocalDateTime fechaFin = LocalDateTime.now();

    @Column(nullable = false, length = 30)
    private String estado;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "fk_planproduccion", nullable = false)
    @ToString.Exclude
    private PlanProduccionEntity planProduccion;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "fk_usuario", nullable = false)
    @ToString.Exclude
    private UsuarioEntity usuario;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "fk_producto", nullable = false)
    @ToString.Exclude
    private ProductoEntity producto;

    @OneToMany(mappedBy = "ordenProduccion", fetch = FetchType.LAZY)
    @ToString.Exclude
    private List<EnsayoLaboratorioEntity> ensayosLaboratorio = new ArrayList<>();

    @OneToMany(mappedBy = "ordenProduccion", fetch = FetchType.LAZY)
    @ToString.Exclude
    private List<AuditoriaLoteEntity> auditorias = new ArrayList<>();

    @OneToMany(mappedBy = "ordenProduccion", fetch = FetchType.LAZY)
    @ToString.Exclude
    private List<DictamenLoteEntity> dictamenes = new ArrayList<>();

    @OneToMany(mappedBy = "ordenProduccion", fetch = FetchType.LAZY)
    @ToString.Exclude
    private List<HistorialLoteEntity> historial = new ArrayList<>();
}
