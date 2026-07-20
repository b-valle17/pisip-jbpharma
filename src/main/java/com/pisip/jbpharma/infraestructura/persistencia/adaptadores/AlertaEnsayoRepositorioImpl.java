package com.pisip.jbpharma.infraestructura.persistencia.adaptadores;

import java.util.List;
import java.util.Optional;

import com.pisip.jbpharma.dominio.entidades.AlertaEnsayo;
import com.pisip.jbpharma.dominio.repositorio.iAlertaEnsayoRepositorio;
import com.pisip.jbpharma.infraestructura.persistencia.jpa.AlertaEnsayoEntity;
import com.pisip.jbpharma.infraestructura.persistencia.mapeadores.iAlertaEnsayojpaMapper;
import com.pisip.jbpharma.infraestructura.repositorio.iAlertaEnsayojpaRepositorio;

public class AlertaEnsayoRepositorioImpl implements iAlertaEnsayoRepositorio{

	
		private final iAlertaEnsayojpaRepositorio jpaRepositorio;
		private final iAlertaEnsayojpaMapper entityMapper;
		
		public AlertaEnsayoRepositorioImpl(iAlertaEnsayojpaRepositorio jpaRepositorio,
			iAlertaEnsayojpaMapper entityMapper) {
		
		this.jpaRepositorio = jpaRepositorio;
		this.entityMapper = entityMapper;
	}

		@Override
		public AlertaEnsayo guardar(AlertaEnsayo nuevaAlertaEnsayo) {
			AlertaEnsayoEntity entidad = entityMapper.toEntity(nuevaAlertaEnsayo);
			AlertaEnsayoEntity guardado = jpaRepositorio.save(entidad);
			return entityMapper.toDominio(guardado);
		}

		@Override
		public Optional<AlertaEnsayo> buscarPorId(long idAlertaEnsayo) {
			return jpaRepositorio.findById(idAlertaEnsayo).map(entityMapper :: toDominio);
		}

		@Override
		public List<AlertaEnsayo> listarTodos() {
			return jpaRepositorio.findAll().stream().map(entityMapper::toDominio).toList();
		}

		@Override
		public void eliminar(long idAlertaEnsayo) {
			jpaRepositorio.deleteById(idAlertaEnsayo);
			
		}

}
