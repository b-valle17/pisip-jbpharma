package com.pisip.jbpharma.infraestructura.persistencia.jpa;

import java.time.LocalDateTime;
import java.util.List;
import jakarta.persistence.*;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "ensayo_laboratorio")
public class EnsayoLaboratorioEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_ensayo")
    private Long idEnsayo;

    @ManyToOne
    @JoinColumn(name = "id_orden")
    private OrdenProduccionEntity ordenProduccion;
   
    @ManyToOne
    @JoinColumn(name = "id_producto")
    private ProductoEntity producto;

    @Column(name = "codigo_ensayo")
    private String codigoEnsayo;

    @Column(name = "fecha_ensayo")
    private LocalDateTime fechaEnsayo = LocalDateTime.now();

    @Column(name = "responsable")
    private String responsable;

    @Column(name = "observacion")
    private String observacion;

    @Column(name = "estado")
    private String estado = "REGISTRADO";

    @Column(name = "creado_en")
    private LocalDateTime creadoEn = LocalDateTime.now();

    @OneToMany(mappedBy = "fkEnsayoLaboratorioEntity")
    private List<EnsayoVariableEntity> listaEnsayos;

}
