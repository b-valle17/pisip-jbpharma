package com.pisip.jbpharma.aplicacion.casouso.impl;

import java.time.LocalDateTime;
import java.util.List;
import com.pisip.jbpharma.aplicacion.casouso.entrada.iAlertaEnsayoUseCase;
import com.pisip.jbpharma.dominio.entidades.AlertaEnsayo;
import com.pisip.jbpharma.dominio.repositorio.iAlertaEnsayoRepositorio;

public class AlertaEnsayoUseCaseImpl implements iAlertaEnsayoUseCase {
    private final iAlertaEnsayoRepositorio repositorio;
    public AlertaEnsayoUseCaseImpl(iAlertaEnsayoRepositorio repositorio) { this.repositorio = repositorio; }
    @Override public AlertaEnsayo guardar(AlertaEnsayo nuevo) {
        nuevo.setIdAlerta(null);
        if (nuevo.getFechaGeneracion() == null) nuevo.setFechaGeneracion(LocalDateTime.now());
        return repositorio.guardar(nuevo);
    }
    @Override public AlertaEnsayo buscarPorId(long id) { return repositorio.buscarPorId(id).orElseThrow(() -> new RuntimeException("Alerta no encontrada")); }
    @Override public List<AlertaEnsayo> listarTodos() { return repositorio.listarTodos(); }
    @Override public AlertaEnsayo actualizar(long id, AlertaEnsayo datos) {
        AlertaEnsayo actual = buscarPorId(id);
        datos.setIdAlerta(id);
        if (datos.getFechaGeneracion() == null) datos.setFechaGeneracion(actual.getFechaGeneracion());
        return repositorio.guardar(datos);
    }
    @Override public void eliminar(long id) { buscarPorId(id); repositorio.eliminar(id); }
}
