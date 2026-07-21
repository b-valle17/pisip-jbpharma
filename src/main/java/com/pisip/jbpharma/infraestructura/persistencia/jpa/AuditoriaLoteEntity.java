package com.pisip.jbpharma.infraestructura.persistencia.jpa;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@Table(name = "auditoria_lote")
public class AuditoriaLoteEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_auditoria")
    private Integer idAuditoria;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_orden_produccion", nullable = false)
    @ToString.Exclude
    private OrdenProduccionEntity ordenProduccion;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_usuario_auditor", nullable = false)
    @ToString.Exclude
    private UsuarioEntity usuarioAuditor;

    @Column(name = "fecha_auditoria", nullable = false)
    private LocalDateTime fechaAuditoria = LocalDateTime.now();

    @Column(name = "resultado", nullable = false, length = 50)
    private String resultado;

    @Column(name = "observaciones", columnDefinition = "TEXT")
    private String observaciones;

    @OneToMany(mappedBy = "auditoria", cascade = CascadeType.ALL,
               orphanRemoval = true, fetch = FetchType.LAZY)
    @ToString.Exclude
    private List<InformeAuditoriaEntity> informes = new ArrayList<>();
}
