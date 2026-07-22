package com.pisip.jbpharma.infraestructura.persistencia.jpa;

import java.time.LocalDateTime;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@Table(name = "informe_auditoria")
public class InformeAuditoriaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_informe")
    private Integer idInforme;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_auditoria", nullable = false)
    @ToString.Exclude
    private AuditoriaLoteEntity auditoria;

    @Column(name = "fecha_generacion", nullable = false)
    private LocalDateTime fechaGeneracion = LocalDateTime.now();

    @Column(name = "formato", nullable = false, length = 20)
    private String formato;

    @Column(name = "ruta_archivo", nullable = false, length = 500)
    private String rutaArchivo;
}
