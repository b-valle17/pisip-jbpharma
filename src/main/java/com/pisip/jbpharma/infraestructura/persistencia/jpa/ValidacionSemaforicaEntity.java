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
}
