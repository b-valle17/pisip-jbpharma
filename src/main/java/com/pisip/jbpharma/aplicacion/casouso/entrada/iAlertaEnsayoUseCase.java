package com.pisip.jbpharma.aplicacion.casouso.entrada;

import java.util.List;
import com.pisip.jbpharma.dominio.entidades.AlertaEnsayo;

public interface iAlertaEnsayoUseCase {
    AlertaEnsayo guardar(AlertaEnsayo nuevo);
    AlertaEnsayo buscarPorId(long id);
    List<AlertaEnsayo> listarTodos();
    AlertaEnsayo actualizar(long id, AlertaEnsayo datos);
    void eliminar(long id);
}
