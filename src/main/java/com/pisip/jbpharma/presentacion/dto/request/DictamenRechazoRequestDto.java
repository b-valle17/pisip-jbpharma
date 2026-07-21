package com.pisip.jbpharma.presentacion.dto.request;

import jakarta.validation.constraints.NotBlank;

public class DictamenRechazoRequestDto {

	@NotBlank
	private String motivo;

	public String getMotivo() {
		return motivo;
	}

	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}
}
