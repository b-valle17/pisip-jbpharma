package com.pisip.jbpharma.presentacion.dto.request;

import jakarta.validation.constraints.NotBlank;

public class LoginRequestDto {

	@NotBlank
	private String correo;

	@NotBlank
	private String contrasenaHash;

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
}