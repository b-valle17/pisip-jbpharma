package com.pisip.jbpharma.infraestructura.persistencia.jpa;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "rol")
public class RolEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idRol;
    private String nombreRol;
    @Column(name = ("descripcion_rol"))
    private String descripcion;

}
