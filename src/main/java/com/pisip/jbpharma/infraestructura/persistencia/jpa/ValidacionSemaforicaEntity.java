package com.pisip.jbpharma.infraestructura.persistencia.jpa;

import java.time.LocalDateTime;
<<<<<<< HEAD
import java.util.List;
import jakarta.persistence.*;
import lombok.Data;


@Entity
@Data
@Table(name = "validacion_semaforica")
public class ValidacionSemaforicaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_validacion")
    private Long idValidacion;

    @ManyToOne
    @JoinColumn(name = "id_variable")
    private EnsayoVariableEntity fkEnsayoVariableEntity;

    @ManyToOne
    @JoinColumn(name = "id_parametro")
    private ParametroValidacionEntity fkParametroValidacionEntity;

    @Column(name = "resultado")
    private String resultado;

    @Column(name = "mensaje")
    private String mensaje;

    @Column(name = "fecha_validacion")
    private LocalDateTime fechaValidacion = LocalDateTime.now();

    @OneToMany(mappedBy = "fkValidacionSemaforicaEntity")
    private List<AlertaEnsayoEntity> listaAlertas;
=======

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "ValidacionSemaforica")
public class ValidacionSemaforicaEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idValidacion;
	private Long idVariable;
	private Long idParametro;
	@Column(name = "resultado_validacion", length = 50)
	private String resultado;
	@Column(length = 120)
	private String mensaje;
	private LocalDateTime fechaValidacion;
>>>>>>> main
}
