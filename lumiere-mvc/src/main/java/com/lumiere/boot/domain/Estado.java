package com.lumiere.boot.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "ESTADO")
public class Estado extends AbstractEntity<Long> {

	@Column(name = "nome_estado", nullable = false, unique = true, length = 60)
	private String nomeEstado;

	public String getNomeEstado() {
		return nomeEstado;
	}

	public void setNomeEstado(String nomeEstado) {
		this.nomeEstado = nomeEstado;
	}
	
	@Column(name = "UF_estado", nullable = false, unique = true, length = 60)
	private String UfEstado;

	public String getUfEstado() {
		return UfEstado;
	}

	public void setUfEstado(String ufEstado) {
		UfEstado = ufEstado;
	}
	
	
	
	
	
}
