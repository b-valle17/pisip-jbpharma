package com.pisip.jbpharma.infraestructura.persistencia.jpa;

import java.time.LocalDateTime;
<<<<<<< HEAD
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
@Table(name = "alerta_ensayo")
public class AlertaEnsayoEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_alerta")
	private Long idAlerta;

	@ManyToOne
	@JoinColumn(name = "id_validacion")
	private ValidacionSemaforicaEntity fkValidacionSemaforicaEntity;

	@Column(name = "tipo_alerta")
	private String tipoAlerta = "EMAIL";

	@Column(name = "destinatario")
	private String destinatario;

	@Column(name = "asunto")
	private String asunto;

	@Column(name = "mensaje")
	private String mensaje;

	@Column(name = "estado_envio")
	private String estadoEnvio = "PENDIENTE";

	@Column(name = "fecha_generacion")
	private LocalDateTime fechaGeneracion = LocalDateTime.now();

	@Column(name = "fecha_envio")
	private LocalDateTime fechaEnvio;
}
=======
@Table(name = "AlertaEnsayo")
public class AlertaEnsayoEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idAlerta;
	private Long idValidacion;
	private String tipoAlerta;
	@Column(name = "destinatario_alerta")
	private String destinatario;
	@Column(length = 80)
	private String asunto;
	@Column(length = 120)
	private String mensaje;
	private String estadoEnvio;
	private LocalDateTime fechaGeneracion;
	private LocalDateTime fechaEnvio;

}
>>>>>>> main
