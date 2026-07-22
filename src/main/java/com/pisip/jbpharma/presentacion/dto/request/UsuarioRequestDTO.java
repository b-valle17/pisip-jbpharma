package com.pisip.jbpharma.presentacion.dto.request;

import java.util.Date;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class UsuarioRequestDTO {

	private Integer idUsuario;
	@NotBlank
    private String nombre;
	@NotBlank
    private String correo;
    private String contrasenaHash;
	@NotNull
    private boolean estadoUsuario;
    private Date fechaCreacion;
    private Integer idRol;

}
