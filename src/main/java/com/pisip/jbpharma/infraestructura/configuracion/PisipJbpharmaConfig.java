package com.pisip.jbpharma.infraestructura.configuracion;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.pisip.jbpharma.aplicacion.casouso.entrada.iAlertaEnsayoUseCase;
import com.pisip.jbpharma.aplicacion.casouso.entrada.iEnsayoLaboratorioUseCase;
import com.pisip.jbpharma.aplicacion.casouso.entrada.iEnsayoVariableUseCase;
import com.pisip.jbpharma.aplicacion.casouso.entrada.iParametroValidacionUseCase;
import com.pisip.jbpharma.aplicacion.casouso.entrada.iUsuarioUseCase;
import com.pisip.jbpharma.aplicacion.casouso.entrada.iValidacionSemaforicaUseCase;
import com.pisip.jbpharma.aplicacion.casouso.impl.AlertaEnsayoUseCaseImpl;
import com.pisip.jbpharma.aplicacion.casouso.impl.EnsayoLaboratorioUseCaseImpl;
import com.pisip.jbpharma.aplicacion.casouso.impl.EnsayoVariableUseCaseImpl;
import com.pisip.jbpharma.aplicacion.casouso.impl.ParametroValidacionUseCaseImpl;
import com.pisip.jbpharma.aplicacion.casouso.impl.UsuarioUseCaseImpl;
import com.pisip.jbpharma.aplicacion.casouso.impl.ValidacionSemaforicaUseCaseImpl;
import com.pisip.jbpharma.dominio.repositorio.iAlertaEnsayoRepositorio;
import com.pisip.jbpharma.dominio.repositorio.iEnsayoLaboratorioRepositorio;
import com.pisip.jbpharma.dominio.repositorio.iEnsayoVariableRepositorio;
import com.pisip.jbpharma.dominio.repositorio.iParametroValidacionRepositorio;
import com.pisip.jbpharma.dominio.repositorio.iUsuarioRepositorio;
import com.pisip.jbpharma.dominio.repositorio.iValidacionSemaforicaRepositorio;
import com.pisip.jbpharma.infraestructura.persistencia.adaptadores.AlertaEnsayoRepositorioImpl;
import com.pisip.jbpharma.infraestructura.persistencia.adaptadores.EnsayoLaboratorioRepositorioImpl;
import com.pisip.jbpharma.infraestructura.persistencia.adaptadores.EnsayoVariableRepositorioImpl;
import com.pisip.jbpharma.infraestructura.persistencia.adaptadores.ParametroValidacionRepositorioImpl;
import com.pisip.jbpharma.infraestructura.persistencia.adaptadores.UsuarioRepositorioImpl;
import com.pisip.jbpharma.infraestructura.persistencia.adaptadores.ValidacionSemaforicaRepositorioImpl;
import com.pisip.jbpharma.infraestructura.persistencia.mapeadores.iAlertaEnsayojpaMapper;
import com.pisip.jbpharma.infraestructura.persistencia.mapeadores.iEnsayoLaboratoriojpaMapper;
import com.pisip.jbpharma.infraestructura.persistencia.mapeadores.iEnsayoVariablejpaMapper;
import com.pisip.jbpharma.infraestructura.persistencia.mapeadores.iParametroValidacionjpaMapper;
import com.pisip.jbpharma.infraestructura.persistencia.mapeadores.iUsuariojpaMapper;
import com.pisip.jbpharma.infraestructura.persistencia.mapeadores.iValidacionSemaforicajpaMapper;
import com.pisip.jbpharma.infraestructura.repositorio.iAlertaEnsayojpaRepositorio;
import com.pisip.jbpharma.infraestructura.repositorio.iEnsayoLaboratoriojpaRepositorio;
import com.pisip.jbpharma.infraestructura.repositorio.iEnsayoVariablejpaRepositorio;
import com.pisip.jbpharma.infraestructura.repositorio.iParametroValidacionjpaRepositorio;
import com.pisip.jbpharma.infraestructura.repositorio.iUsuariojpaRepositorio;
import com.pisip.jbpharma.infraestructura.repositorio.iValidacionSemaforicajpaRepositorio;


@Configuration
public class PisipJbpharmaConfig {

	@Bean
	iAlertaEnsayoRepositorio alertaEnsayoRepositorio(iAlertaEnsayojpaRepositorio jpaRepositorio, iAlertaEnsayojpaMapper mapper) {
		return new AlertaEnsayoRepositorioImpl(jpaRepositorio, mapper);
				
	}

	@Bean
	iAlertaEnsayoUseCase alertaEnsayoUseCase(iAlertaEnsayoRepositorio respositorio) {
		return new AlertaEnsayoUseCaseImpl(respositorio);
	}
	
	@Bean
	iEnsayoLaboratorioRepositorio ensayoLaboratorioRepositorio(iEnsayoLaboratoriojpaRepositorio jpaRepositorio, iEnsayoLaboratoriojpaMapper mapper) {
		return new EnsayoLaboratorioRepositorioImpl(jpaRepositorio, mapper);
				
	}

	@Bean
	iEnsayoLaboratorioUseCase EnsayoLaboratorioUseCase(iEnsayoLaboratorioRepositorio respositorio) {
		return new EnsayoLaboratorioUseCaseImpl(respositorio);
	}
	
	@Bean
	iEnsayoVariableRepositorio ensayoVariableRepositorio(iEnsayoVariablejpaRepositorio jpaRepositorio, iEnsayoVariablejpaMapper mapper) {
		return new EnsayoVariableRepositorioImpl(jpaRepositorio, mapper);
				
	}

	@Bean
	iEnsayoVariableUseCase EnsayoVariableUseCase(iEnsayoVariableRepositorio respositorio) {
		return new EnsayoVariableUseCaseImpl(respositorio);
	}
	
	@Bean
	iParametroValidacionRepositorio parametroValidacionRepositorio(iParametroValidacionjpaRepositorio jpaRepositorio, iParametroValidacionjpaMapper mapper) {
		return new ParametroValidacionRepositorioImpl(jpaRepositorio, mapper);
				
	}

	@Bean
	iParametroValidacionUseCase ParametroValidacionUseCase(iParametroValidacionRepositorio respositorio) {
		return new ParametroValidacionUseCaseImpl(respositorio);
	}
	
	@Bean
	iUsuarioRepositorio usuarioRepositorio(iUsuariojpaRepositorio jpaRepositorio, iUsuariojpaMapper mapper) {
		return new UsuarioRepositorioImpl(jpaRepositorio, mapper);
				
	}

	@Bean
	iUsuarioUseCase UsuarioUseCase(iUsuarioRepositorio respositorio) {
		return new UsuarioUseCaseImpl(respositorio);
	}
	
	@Bean
	iValidacionSemaforicaRepositorio validacionSemaforicaRepositorio(iValidacionSemaforicajpaRepositorio jpaRepositorio, iValidacionSemaforicajpaMapper mapper) {
		return new ValidacionSemaforicaRepositorioImpl(jpaRepositorio, mapper);
				
	}

	@Bean
	iValidacionSemaforicaUseCase ValidacionSemaforicaUseCase(iValidacionSemaforicaRepositorio respositorio) {
		return new ValidacionSemaforicaUseCaseImpl(respositorio);
	}
	
	
}
