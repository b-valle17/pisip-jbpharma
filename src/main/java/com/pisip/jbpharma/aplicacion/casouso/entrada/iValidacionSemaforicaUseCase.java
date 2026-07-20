package com.pisip.jbpharma.aplicacion.casouso.entrada;

import java.util.List;
import com.pisip.jbpharma.dominio.entidades.ValidacionSemaforica;

public interface iValidacionSemaforicaUseCase {
    ValidacionSemaforica guardar(ValidacionSemaforica nuevo);
    ValidacionSemaforica buscarPorId(long id);
    List<ValidacionSemaforica> listarTodos();
    ValidacionSemaforica actualizar(long id, ValidacionSemaforica datos);
    void eliminar(long id);
}
