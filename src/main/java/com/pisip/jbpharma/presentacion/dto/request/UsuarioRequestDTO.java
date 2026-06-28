package com.pisip.jbpharma.presentacion.dto.request;

import java.util.Date;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class UsuarioRequestDTO {
	
	@NotBlank
	private int idUsuario;
	@NotBlank
    private String nombre;
	@NotBlank
    private String correo;
	@NotBlank
    private String contrasenaHash;
	@NotBlank
    private boolean estadoUsuario;
	@NotBlank
    private Date fechaCreacion;

}
