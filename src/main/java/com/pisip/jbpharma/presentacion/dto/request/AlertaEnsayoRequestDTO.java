package com.pisip.jbpharma.presentacion.dto.request;

import java.time.LocalDateTime;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
public class AlertaEnsayoRequestDTO {
    private Long idAlerta;
    @NotNull @Positive private Long idValidacion;
    @NotBlank private String tipoAlerta;
    @NotBlank @Email private String destinatario;
    @NotBlank private String asunto;
    @NotBlank private String mensaje;
    @NotBlank private String estadoEnvio;
    private LocalDateTime fechaGeneracion;
    private LocalDateTime fechaEnvio;
}
