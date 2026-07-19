package com.pisip.jbpharma.aplicacion.casouso.entrada;
import java.util.List;
import com.pisip.jbpharma.dominio.entidades.EnsayoLaboratorio;
public interface iEnsayoLaboratorioUseCase {
    EnsayoLaboratorio guardar(EnsayoLaboratorio nuevo);
    EnsayoLaboratorio buscarPorId(long id);
    List<EnsayoLaboratorio> listarTodos();
    EnsayoLaboratorio actualizar(long id, EnsayoLaboratorio datos);
    void eliminar(long id);
    List<EnsayoLaboratorio> buscar(String texto);
}
