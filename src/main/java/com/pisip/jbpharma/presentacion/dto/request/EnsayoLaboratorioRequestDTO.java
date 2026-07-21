package com.pisip.jbpharma.presentacion.dto.request;

import java.time.LocalDateTime;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
public class EnsayoLaboratorioRequestDTO {
    private Long idEnsayo;
    @NotNull @Positive private Integer idOrden;
    @NotNull @Positive private Integer idProducto;
    private String codigoEnsayo;
    @NotNull private LocalDateTime fechaEnsayo;
    @NotBlank private String responsable;
    private String observacion;
    @NotBlank private String estado;
    private LocalDateTime creadoEn;
}
