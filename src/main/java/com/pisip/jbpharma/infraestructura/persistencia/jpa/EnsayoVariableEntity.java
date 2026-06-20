package com.pisip.jbpharma.infraestructura.persistencia.jpa;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "EnsayoVariable")
public class EnsayoVariableEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idVariable;
	private Long idEnsayo;
	private String nombreVariable;
	private BigDecimal valorObtenido;
	private String unidadMedida;
	private LocalDateTime creadoEn;
}
