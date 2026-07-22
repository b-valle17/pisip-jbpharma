package com.pisip.jbpharma.presentacion.dto.request;

import java.time.LocalDateTime;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
public class ValidacionSemaforicaRequestDTO {
    private Long idValidacion;
    @NotNull @Positive private Long idVariable;
    @NotNull @Positive private Integer idParametro;
    @NotBlank private String resultado;
    private String mensaje;
    @NotNull private LocalDateTime fechaValidacion;
}
