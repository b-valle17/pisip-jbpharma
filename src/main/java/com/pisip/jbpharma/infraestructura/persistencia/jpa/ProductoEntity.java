package com.pisip.jbpharma.infraestructura.persistencia.jpa;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

@Entity
@Data
@Table(name = "producto")
public class ProductoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_producto")
    private Integer idProducto;

    @Column(name = "nombre_producto", nullable = false, unique = true, length = 120)
    private String nombreProducto;

    @Column(name = "descripcion_producto", length = 255)
    private String descripcion;

    @OneToMany(mappedBy = "producto", fetch = FetchType.LAZY)
    @ToString.Exclude
    private List<ParametroCalidadEntity> parametrosCalidad = new ArrayList<>();

    @OneToMany(mappedBy = "producto", fetch = FetchType.LAZY)
    @ToString.Exclude
    private List<ParametroCalidadEntity> parametrosValidacion = new ArrayList<>();

    @OneToMany(mappedBy = "producto", fetch = FetchType.LAZY)
    @ToString.Exclude
    private List<OrdenProduccionEntity> ordenesProduccion = new ArrayList<>();

    @OneToMany(mappedBy = "producto", fetch = FetchType.LAZY)
    @ToString.Exclude
    private List<EnsayoLaboratorioEntity> ensayosLaboratorio = new ArrayList<>();
}
