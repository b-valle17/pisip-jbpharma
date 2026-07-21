package com.pisip.jbpharma.dominio.entidades;

import java.util.Date;

public class Usuario {
	
	private Integer idUsuario;
    private String nombre;
    private String correo;
    private String contrasenaHash;
    private boolean estadoUsuario;
    private Date fechaCreacion;
    private Integer idRol;
    
	public Usuario() {
		super();
	}

	public Usuario(Integer idUsuario, String nombre, String correo, String contrasenaHash, boolean estadoUsuario,
			Date fechaCreacion, Integer idRol) {
		super();
		this.idUsuario = idUsuario;
		this.nombre = nombre;
		this.correo = correo;
		this.contrasenaHash = contrasenaHash;
		this.estadoUsuario = estadoUsuario;
		this.fechaCreacion = fechaCreacion;
		this.idRol = idRol;
	}

	public Integer getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Integer idUsuario) {
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

	public Integer getIdRol() {
		return idRol;
	}

	public void setIdRol(Integer idRol) {
		this.idRol = idRol;
	}
	
}
