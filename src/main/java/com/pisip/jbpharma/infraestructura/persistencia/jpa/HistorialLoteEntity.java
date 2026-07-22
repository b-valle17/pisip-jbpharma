package com.pisip.jbpharma.infraestructura.persistencia.jpa;

import java.time.LocalDateTime;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@Table(name = "historial_lote")
public class HistorialLoteEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_historial")
    private Integer idHistorial;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_orden_produccion", nullable = false)
    @ToString.Exclude
    private OrdenProduccionEntity ordenProduccion;

    @Column(name = "fecha_evento", nullable = false)
    private LocalDateTime fechaEvento = LocalDateTime.now();

    @Column(name = "accion", nullable = false, length = 100)
    private String accion;

    @Column(name = "descripcion", columnDefinition = "TEXT")
    private String descripcion;
}
