package com.pisip.jbpharma.dominio.entidades;

public class Producto {

	private int idProducto;
    private String nombreProducto;
    private String descripcion;
    
	public Producto() {
		super();
	}
	
	public Producto(int idProducto, String nombreProducto, String descripcion) {
		super();
		this.idProducto = idProducto;
		this.nombreProducto = nombreProducto;
		this.descripcion = descripcion;
	}
	
	public int getIdProducto() {
		return idProducto;
	}
	
	public void setIdProducto(int idProducto) {
		this.idProducto = idProducto;
	}
	
	public String getNombreProducto() {
		return nombreProducto;
	}
	
	public void setNombreProducto(String nombreProducto) {
		this.nombreProducto = nombreProducto;
	}
	
	public String getDescripcion() {
		return descripcion;
	}
	
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
    
}
