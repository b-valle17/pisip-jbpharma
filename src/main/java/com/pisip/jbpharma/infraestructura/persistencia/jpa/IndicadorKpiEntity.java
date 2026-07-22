package com.pisip.jbpharma.infraestructura.persistencia.jpa;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "indicador_kpi")
public class IndicadorKpiEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_kpi")
    private Integer idKpi;

    @Column(name = "nombre_indicador", nullable = false, length = 120)
    private String nombreIndicador;

    @Column(name = "valor", nullable = false, precision = 14, scale = 4)
    private BigDecimal valor;

    @Column(name = "fecha_calculo", nullable = false)
    private LocalDateTime fechaCalculo = LocalDateTime.now();

    @Column(name = "descripcion", length = 255)
    private String descripcion;
}
