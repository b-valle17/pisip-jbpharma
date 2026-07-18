package com.pisip.jbpharma.presentacion.dto.request;

import java.util.Date;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class UsuarioRequestDTO {
	
	@NotNull
	private int idUsuario;
	@NotBlank
    private String nombre;
	@NotBlank
    private String correo;
	@NotBlank
    private String contrasenaHash;
	@NotNull
    private boolean estadoUsuario;
    private Date fechaCreacion;
    private int idRol;

}
