package com.pisip.jbpharma.aplicacion.casouso.entrada;

import java.util.List;

import com.pisip.jbpharma.dominio.entidades.ValidacionSemaforica;

public interface iValidacionSemaforicaUseCase {
	
	ValidacionSemaforica guardar(ValidacionSemaforica nuevaValidacionSemaforica);
	ValidacionSemaforica buscarPorId(int idValidacionSemaforica);
	List<ValidacionSemaforica> listarTodos();
	void eliminar(int idValidacionSemaforica);

}
