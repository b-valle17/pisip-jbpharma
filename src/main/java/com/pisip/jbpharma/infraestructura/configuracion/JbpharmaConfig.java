package com.pisip.jbpharma.infraestructura.configuracion;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.pisip.jbpharma.aplicacion.casouso.entrada.IProductoUseCase;
import com.pisip.jbpharma.aplicacion.casouso.entrada.IParametroCalidadUseCase;
import com.pisip.jbpharma.aplicacion.casouso.entrada.IRolUseCase;
import com.pisip.jbpharma.aplicacion.casouso.entrada.IUsuarioUseCase;
import com.pisip.jbpharma.aplicacion.casouso.entrada.iAlertaEnsayoUseCase;
import com.pisip.jbpharma.aplicacion.casouso.entrada.iEnsayoLaboratorioUseCase;
import com.pisip.jbpharma.aplicacion.casouso.entrada.iEnsayoVariableUseCase;
import com.pisip.jbpharma.aplicacion.casouso.entrada.iParametroValidacionUseCase;
import com.pisip.jbpharma.aplicacion.casouso.entrada.iValidacionSemaforicaUseCase;
import com.pisip.jbpharma.aplicacion.casouso.impl.ProductoUseCaseImpl;
import com.pisip.jbpharma.aplicacion.casouso.impl.AlertaEnsayoUseCaseImpl;
import com.pisip.jbpharma.aplicacion.casouso.impl.EnsayoLaboratorioUseCaseImpl;
import com.pisip.jbpharma.aplicacion.casouso.impl.EnsayoVariableUseCaseImpl;
import com.pisip.jbpharma.aplicacion.casouso.impl.ParametroCalidadUseCaseImpl;
import com.pisip.jbpharma.aplicacion.casouso.impl.ParametroValidacionUseCaseImpl;
import com.pisip.jbpharma.aplicacion.casouso.impl.RolUseCaseImpl;
import com.pisip.jbpharma.aplicacion.casouso.impl.UsuarioUseCaseImpl;
import com.pisip.jbpharma.aplicacion.casouso.impl.ValidacionSemaforicaUseCaseImpl;
import com.pisip.jbpharma.dominio.repositorio.IProductoRepositorio;
import com.pisip.jbpharma.dominio.repositorio.IParametroCalidadRepositorio;
import com.pisip.jbpharma.dominio.repositorio.IRolRepositorio;
import com.pisip.jbpharma.dominio.repositorio.IUsuarioRepositorio;
import com.pisip.jbpharma.dominio.repositorio.iAlertaEnsayoRepositorio;
import com.pisip.jbpharma.dominio.repositorio.iEnsayoLaboratorioRepositorio;
import com.pisip.jbpharma.dominio.repositorio.iEnsayoVariableRepositorio;
import com.pisip.jbpharma.dominio.repositorio.iParametroValidacionRepositorio;
import com.pisip.jbpharma.dominio.repositorio.iValidacionSemaforicaRepositorio;
import com.pisip.jbpharma.infraestructura.persistencia.adaptadores.ProductoRepositorioImpl;
import com.pisip.jbpharma.infraestructura.persistencia.adaptadores.AlertaEnsayoRepositorioImpl;
import com.pisip.jbpharma.infraestructura.persistencia.adaptadores.EnsayoLaboratorioRepositorioImpl;
import com.pisip.jbpharma.infraestructura.persistencia.adaptadores.EnsayoVariableRepositorioImpl;
import com.pisip.jbpharma.infraestructura.persistencia.adaptadores.ParametroCalidadRepositorioImpl;
import com.pisip.jbpharma.infraestructura.persistencia.adaptadores.ParametroValidacionRepositorioImpl;
import com.pisip.jbpharma.infraestructura.persistencia.adaptadores.RolRepositorioImpl;
import com.pisip.jbpharma.infraestructura.persistencia.adaptadores.UsuarioRepositorioImpl;
import com.pisip.jbpharma.infraestructura.persistencia.adaptadores.ValidacionSemaforicaRepositorioImpl;
import com.pisip.jbpharma.infraestructura.persistencia.mapeadores.IProductoJpaMapper;
import com.pisip.jbpharma.infraestructura.persistencia.mapeadores.IParametroCalidadJpaMapper;
import com.pisip.jbpharma.infraestructura.persistencia.mapeadores.IRolJpaMapper;
import com.pisip.jbpharma.infraestructura.persistencia.mapeadores.IUsuarioJpaMapper;
import com.pisip.jbpharma.infraestructura.persistencia.mapeadores.iAlertaEnsayojpaMapper;
import com.pisip.jbpharma.infraestructura.persistencia.mapeadores.iEnsayoLaboratoriojpaMapper;
import com.pisip.jbpharma.infraestructura.persistencia.mapeadores.iEnsayoVariablejpaMapper;
import com.pisip.jbpharma.infraestructura.persistencia.mapeadores.iParametroValidacionjpaMapper;
import com.pisip.jbpharma.infraestructura.persistencia.mapeadores.iValidacionSemaforicajpaMapper;
import com.pisip.jbpharma.infraestructura.repositorio.IProductoJpaRepositorio;
import com.pisip.jbpharma.infraestructura.repositorio.IParametroCalidadJpaRepositorio;
import com.pisip.jbpharma.infraestructura.repositorio.IRolJpaRepositorio;
import com.pisip.jbpharma.infraestructura.repositorio.IUsuarioJpaRepositorio;
import com.pisip.jbpharma.infraestructura.repositorio.iAlertaEnsayojpaRepositorio;
import com.pisip.jbpharma.infraestructura.repositorio.iEnsayoLaboratoriojpaRepositorio;
import com.pisip.jbpharma.infraestructura.repositorio.iEnsayoVariablejpaRepositorio;
import com.pisip.jbpharma.infraestructura.repositorio.iParametroValidacionjpaRepositorio;
import com.pisip.jbpharma.infraestructura.repositorio.iValidacionSemaforicajpaRepositorio;

@Configuration
@EnableWebSecurity
public class JbpharmaConfig {

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.csrf(csrf -> csrf.disable()).authorizeHttpRequests(auth -> auth
				.requestMatchers("/api/usuarios", "/api/usuarios/login", "/api/productos", "/api/parametros-calidad", "/api/productos/**", "/api/parametros-calidad/**").permitAll().anyRequest().authenticated());

		return http.build();
	}

	@Bean
	IUsuarioRepositorio usuarioRepositorio(IUsuarioJpaRepositorio jpaRepositorio, IUsuarioJpaMapper mapper) {
		return new UsuarioRepositorioImpl(jpaRepositorio, mapper);
	}

	@Bean
	IUsuarioUseCase usuarioUseCase(IUsuarioRepositorio repositorio, PasswordEncoder passwordEncoder) {
		return new UsuarioUseCaseImpl(repositorio, passwordEncoder);
	}

	@Bean
	IRolRepositorio rolRepositorio(IRolJpaRepositorio jpaRepositorio, IRolJpaMapper mapper) {
		return new RolRepositorioImpl(jpaRepositorio, mapper);
	}

	@Bean
	IRolUseCase rolUseCase(IRolRepositorio repositorio) {
		return new RolUseCaseImpl(repositorio);
	}

	@Bean
	IParametroCalidadRepositorio parametroCalidadRepositorio(IParametroCalidadJpaRepositorio jpaRepositorio,
			IParametroCalidadJpaMapper mapper) {
		return new ParametroCalidadRepositorioImpl(jpaRepositorio, mapper);
	}

	@Bean
	IParametroCalidadUseCase parametroCalidadUseCase(IParametroCalidadRepositorio repositorio) {
		return new ParametroCalidadUseCaseImpl(repositorio);
	}

	@Bean
	IProductoRepositorio productoRepositorio(IProductoJpaRepositorio jpaRepositorio, IProductoJpaMapper mapper) {
		return new ProductoRepositorioImpl(jpaRepositorio, mapper);
	}

	@Bean
	IProductoUseCase productoUseCase(IProductoRepositorio repositorio) {
		return new ProductoUseCaseImpl(repositorio);
	}
	
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
	iValidacionSemaforicaRepositorio validacionSemaforicaRepositorio(iValidacionSemaforicajpaRepositorio jpaRepositorio, iValidacionSemaforicajpaMapper mapper) {
		return new ValidacionSemaforicaRepositorioImpl(jpaRepositorio, mapper);
				
	}

	@Bean
	iValidacionSemaforicaUseCase ValidacionSemaforicaUseCase(iValidacionSemaforicaRepositorio respositorio) {
		return new ValidacionSemaforicaUseCaseImpl(respositorio);
	}
}