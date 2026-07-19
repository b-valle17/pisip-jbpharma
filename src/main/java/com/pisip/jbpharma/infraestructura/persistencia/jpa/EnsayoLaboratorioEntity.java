package com.pisip.jbpharma.infraestructura.persistencia.jpa;

import java.time.LocalDateTime;
<<<<<<< HEAD
import java.util.List;
import jakarta.persistence.*;
=======

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
>>>>>>> main
import lombok.Data;

@Entity
@Data
<<<<<<< HEAD
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
=======
@Table(name = "EnsayoLaboratorio")
public class EnsayoLaboratorioEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idEnsayo;
	private Integer idLote;
	private Integer idProducto;
	private String codigoEnsayo;
	private LocalDateTime fechaEnsayo;
	@Column(name = "responsable_ensayo")
	private String responsable;
	@Column(length = 80)
	private String observacion;
	private String estado;
	private LocalDateTime creadoEn;
>>>>>>> main
}
