package com.pisip.jbpharma.presentacion.dto.request;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
public class EnsayoVariableRequestDTO {
    private Long idVariable;
    @NotNull @Positive private Long idEnsayo;
    @NotBlank private String nombreVariable;
    @NotNull private BigDecimal valorObtenido;
    @NotBlank private String unidadMedida;
    private LocalDateTime creadoEn;
}
