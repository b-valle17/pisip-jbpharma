package com.pisip.jbpharma.infraestructura.persistencia.jpa;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
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
