package com.pisip.jbpharma.infraestructura.persistencia.jpa;

import java.time.LocalDate;
import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

@Entity
@Data
@Table(name = "dictamen_lote")
public class DictamenLoteEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_dictamen")
    private Integer idDictamen;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_orden_produccion", nullable = false)
    @ToString.Exclude
    private OrdenProduccionEntity ordenProduccion;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_usuario_inspector", nullable = false)
    @ToString.Exclude
    private UsuarioEntity usuarioInspector;

    @Column(name = "fecha_dictamen", nullable = false)
    private LocalDate fechaDictamen;

    @Column(name = "estado", nullable = false, length = 30)
    private String estado;

    @Column(name = "observaciones", columnDefinition = "TEXT")
    private String observaciones;
}
