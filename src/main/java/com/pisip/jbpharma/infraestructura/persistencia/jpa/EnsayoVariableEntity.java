package com.pisip.jbpharma.infraestructura.persistencia.jpa;
<<<<<<< HEAD

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.Column;
=======
import java.math.BigDecimal;
import java.time.LocalDateTime;
>>>>>>> main
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
<<<<<<< HEAD
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

=======
import jakarta.persistence.Table;
>>>>>>> main
import lombok.Data;

@Entity
@Data
<<<<<<< HEAD
@Table(name = "ensayo_variable")
public class EnsayoVariableEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_variable")
    private Long idVariable;

    @ManyToOne
    @JoinColumn(name = "id_ensayo")
    private EnsayoLaboratorioEntity fkEnsayoLaboratorioEntity;

    @Column(name = "nombre_variable")
    private String nombreVariable;

    @Column(name = "valor_obtenido", precision = 12, scale = 4)
    private BigDecimal valorObtenido;

    @Column(name = "unidad_medida")
    private String unidadMedida;

    @Column(name = "creado_en")
    private LocalDateTime creadoEn = LocalDateTime.now();

    @OneToMany(mappedBy = "fkEnsayoVariableEntity")
    private List<ValidacionSemaforicaEntity> listaValidaciones;
}
=======
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
>>>>>>> main
