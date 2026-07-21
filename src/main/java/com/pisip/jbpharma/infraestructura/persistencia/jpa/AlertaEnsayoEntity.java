package com.pisip.jbpharma.infraestructura.persistencia.jpa;

import java.time.LocalDateTime;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
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