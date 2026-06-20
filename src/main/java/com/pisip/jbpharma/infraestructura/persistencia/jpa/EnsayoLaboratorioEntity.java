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
}
