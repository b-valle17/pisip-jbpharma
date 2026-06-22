package com.pisip.jbpharma.infraestructura.persistencia.jpa;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "auditoria_lote")
public class AuditoriaLoteEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private int idAuditoria;
	private int idOrdenProduccion;
	private int idUsuarioAuditor;
	private Date fechaAuditoria;
	private String resultado;
	private String observaciones;

}
