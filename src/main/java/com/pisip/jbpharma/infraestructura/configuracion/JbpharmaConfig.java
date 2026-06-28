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
import com.pisip.jbpharma.aplicacion.casouso.impl.ProductoUseCaseImpl;
import com.pisip.jbpharma.aplicacion.casouso.impl.ParametroCalidadUseCaseImpl;
import com.pisip.jbpharma.aplicacion.casouso.impl.RolUseCaseImpl;
import com.pisip.jbpharma.aplicacion.casouso.impl.UsuarioUseCaseImpl;
import com.pisip.jbpharma.dominio.repositorio.IProductoRepositorio;
import com.pisip.jbpharma.dominio.repositorio.IParametroCalidadRepositorio;
import com.pisip.jbpharma.dominio.repositorio.IRolRepositorio;
import com.pisip.jbpharma.dominio.repositorio.IUsuarioRepositorio;
import com.pisip.jbpharma.infraestructura.persistencia.adaptadores.ProductoRepositorioImpl;
import com.pisip.jbpharma.infraestructura.persistencia.adaptadores.ParametroCalidadRepositorioImpl;
import com.pisip.jbpharma.infraestructura.persistencia.adaptadores.RolRepositorioImpl;
import com.pisip.jbpharma.infraestructura.persistencia.adaptadores.UsuarioRepositorioImpl;
import com.pisip.jbpharma.infraestructura.persistencia.mapeadores.IProductoJpaMapper;
import com.pisip.jbpharma.infraestructura.persistencia.mapeadores.IParametroCalidadJpaMapper;
import com.pisip.jbpharma.infraestructura.persistencia.mapeadores.IRolJpaMapper;
import com.pisip.jbpharma.infraestructura.persistencia.mapeadores.IUsuarioJpaMapper;
import com.pisip.jbpharma.infraestructura.repositorio.IProductoJpaRepositorio;
import com.pisip.jbpharma.infraestructura.repositorio.IParametroCalidadJpaRepositorio;
import com.pisip.jbpharma.infraestructura.repositorio.IRolJpaRepositorio;
import com.pisip.jbpharma.infraestructura.repositorio.IUsuarioJpaRepositorio;

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
				.requestMatchers("/api/usuarios", "/api/usuarios/login").permitAll().anyRequest().authenticated());

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
}