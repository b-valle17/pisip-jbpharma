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
@Table(name = "plan_produccion")
public class PlanProduccionEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_plan")
	private int idPlan;
	@Column(name = "codigo_plan", nullable = false, unique = true, length = 30)
	private String codigoPlan;
	private int mes;
	private int anio;
	@Column(name = "fecha_emision", nullable = false)
	private Date fechaEmision;
	@Column(length = 30)
	private String estado;
	@Column(length = 255)
	private String descripcion;

	@ManyToOne
	@JoinColumn(name = "fk_usuario")
	private UsuarioEntity fkUsuarioEntity;
	
	@OneToMany(mappedBy = "fkPlanProduccionEntity")
	private List<OrdenProduccionEntity> ordenproduccion;
	
}
