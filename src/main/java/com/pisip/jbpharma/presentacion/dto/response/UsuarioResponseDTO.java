package com.pisip.jbpharma.presentacion.dto.response;

import java.util.Date;

import lombok.Data;

@Data
public class UsuarioResponseDTO {
	
	private int idUsuario;
    private String nombre;
    private String correo;
    private String contrasenaHash;
    private boolean estadoUsuario;
    private Date fechaCreacion;

}
