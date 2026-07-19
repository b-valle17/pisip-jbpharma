package com.pisip.jbpharma.presentacion.dto.request;

import java.util.Date;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class UsuarioRequestDto {

	@NotNull
	private int idUsuario;

	@NotBlank
	private String nombre;

	@NotBlank
	private String correo;

	@NotBlank
	private String contrasenaHash;

	private boolean estadoUsuario;

	private Date fechaCreacion;

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getContrasenaHash() {
		return contrasenaHash;
	}

	public void setContrasenaHash(String contrasenaHash) {
		this.contrasenaHash = contrasenaHash;
	}

	public boolean isEstadoUsuario() {
		return estadoUsuario;
	}

	public void setEstadoUsuario(boolean estadoUsuario) {
		this.estadoUsuario = estadoUsuario;
	}

	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}
}