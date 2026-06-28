package com.pisip.jbpharma.presentacion.dto.response;

public class LoginResponseDto {

	private boolean autenticado;
	private String mensaje;
	private UsuarioResponseDto usuario;

	public boolean isAutenticado() {
		return autenticado;
	}

	public void setAutenticado(boolean autenticado) {
		this.autenticado = autenticado;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public UsuarioResponseDto getUsuario() {
		return usuario;
	}

	public void setUsuario(UsuarioResponseDto usuario) {
		this.usuario = usuario;
}
}