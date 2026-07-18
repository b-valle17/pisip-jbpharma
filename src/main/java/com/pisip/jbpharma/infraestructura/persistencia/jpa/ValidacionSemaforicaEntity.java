package com.pisip.jbpharma.infraestructura.persistencia.jpa;

import java.time.LocalDateTime;
import java.util.List;
import jakarta.persistence.*;
import lombok.Data;


@Entity
@Data
@Table(name = "validacion_semaforica")
public class ValidacionSemaforicaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_validacion")
    private Long idValidacion;

    @ManyToOne
    @JoinColumn(name = "id_variable")
    private EnsayoVariableEntity fkEnsayoVariableEntity;

    @ManyToOne
    @JoinColumn(name = "id_parametro")
    private ParametroValidacionEntity fkParametroValidacionEntity;

    @Column(name = "resultado")
    private String resultado;

    @Column(name = "mensaje")
    private String mensaje;

    @Column(name = "fecha_validacion")
    private LocalDateTime fechaValidacion = LocalDateTime.now();

    @OneToMany(mappedBy = "fkValidacionSemaforicaEntity")
    private List<AlertaEnsayoEntity> listaAlertas;
}
