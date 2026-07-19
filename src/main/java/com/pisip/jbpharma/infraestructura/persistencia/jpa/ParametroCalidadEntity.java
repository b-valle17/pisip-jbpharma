package com.pisip.jbpharma.infraestructura.persistencia.jpa;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@Table(name = "parametro_calidad")
public class ParametroCalidadEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_parametro")
    private Integer idParametro;

    @Column(name = "nombre_parametro", nullable = false, length = 100)
    private String nombreParametro;

    @Column(name = "limite_minimo", nullable = false, precision = 12, scale = 4)
    private BigDecimal limiteMinimo;

    @Column(name = "limite_maximo", nullable = false, precision = 12, scale = 4)
    private BigDecimal limiteMaximo;

    @Column(name = "unidad_medida", length = 30)
    private String unidadMedida;

    @Column(name = "fecha_configuracion", nullable = false)
    private LocalDateTime fechaConfiguracion = LocalDateTime.now();

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "fk_producto", nullable = false)
    @ToString.Exclude
    private ProductoEntity producto;
}
