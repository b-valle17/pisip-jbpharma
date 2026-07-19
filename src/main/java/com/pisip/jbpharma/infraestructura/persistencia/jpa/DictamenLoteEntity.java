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
@Table(name = "dictamen_lote")
public class DictamenLoteEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idDictamen;
	private int idOrdenProduccion;
	private int idUsuarioInspector;
	private Date fechaDictamen;
	private String estado;
	private String observaciones;
}
