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
@Table(name = "historial_lote")
public class HistorialLoteEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idHistorial;
	private int idOrdenProduccion;
	private Date fechaEvento;
	private String accion;
	private String descripcion;
	

}
