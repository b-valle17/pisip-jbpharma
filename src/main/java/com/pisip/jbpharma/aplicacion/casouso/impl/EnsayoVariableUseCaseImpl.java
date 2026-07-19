package com.pisip.jbpharma.aplicacion.casouso.impl;

import java.time.LocalDateTime;
import java.util.List;
import com.pisip.jbpharma.aplicacion.casouso.entrada.iEnsayoVariableUseCase;
import com.pisip.jbpharma.dominio.entidades.EnsayoVariable;
import com.pisip.jbpharma.dominio.repositorio.iEnsayoVariableRepositorio;

public class EnsayoVariableUseCaseImpl implements iEnsayoVariableUseCase {
    private final iEnsayoVariableRepositorio repositorio;
    public EnsayoVariableUseCaseImpl(iEnsayoVariableRepositorio repositorio) { this.repositorio = repositorio; }
    @Override public EnsayoVariable guardar(EnsayoVariable nuevo) {
        nuevo.setIdVariable(null);
        if (nuevo.getCreadoEn() == null) nuevo.setCreadoEn(LocalDateTime.now());
        return repositorio.guardar(nuevo);
    }
    @Override public EnsayoVariable buscarPorId(long id) { return repositorio.buscarPorId(id).orElseThrow(() -> new RuntimeException("Variable no encontrada")); }
    @Override public List<EnsayoVariable> listarTodos() { return repositorio.listarTodos(); }
    @Override public EnsayoVariable actualizar(long id, EnsayoVariable datos) {
        EnsayoVariable actual = buscarPorId(id);
        datos.setIdVariable(id);
        if (datos.getCreadoEn() == null) datos.setCreadoEn(actual.getCreadoEn());
        return repositorio.guardar(datos);
    }
    @Override public void eliminar(long id) { buscarPorId(id); repositorio.eliminar(id); }
}
