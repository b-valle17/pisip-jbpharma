package com.pisip.jbpharma.aplicacion.casouso.entrada;

import java.util.List;
import com.pisip.jbpharma.dominio.entidades.EnsayoVariable;

public interface iEnsayoVariableUseCase {
    EnsayoVariable guardar(EnsayoVariable nuevo);
    EnsayoVariable buscarPorId(long id);
    List<EnsayoVariable> listarTodos();
    EnsayoVariable actualizar(long id, EnsayoVariable datos);
    void eliminar(long id);
}
