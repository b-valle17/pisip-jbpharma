package com.pisip.jbpharma.infraestructura.persistencia.jpa;

import java.util.Date;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "usuario")
public class UsuarioEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idUsuario;
	@Column(name = ("nombre_usuario"))
    private String nombre;
	@Column(name = ("correo_usuario"))
    private String correo;
    private String contrasenaHash;
    private boolean estadoUsuario;
    private Date fechaCreacion;

	@ManyToOne
	@JoinColumn(name = "fk_rol")
	private RolEntity fkRolEntity;
	
	@OneToMany(mappedBy = "fkUsuarioEntity")
	private List<PlanProduccionEntity> planproduccion;
	
	@OneToMany(mappedBy = "fkUsuarioEntity")
	private List<OrdenProduccionEntity> ordenproduccion;

}
