package com.lumiere.boot.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "RESIDENCIA")
public class Residencia extends AbstractEntity<Long> {

	@Column(name = "registro_residencia", nullable = false, unique = true, length = 60)
	private String registroResidencia;

	public String getRegistroResidencia() {
		return registroResidencia;
	}

	public void setRegistroResidencia(String registroResidencia) {
		this.registroResidencia = registroResidencia;
	}
	
	@Column(name = "nome_residencia", nullable = false, unique = true, length = 60)
	private String nomeResidencia;

	public String getNomeResidencia() {
		return nomeResidencia;
	}

	public void setNomeResidencia(String nomeResidencia) {
		this.nomeResidencia = nomeResidencia;
	}
	
	@Column(name = "endereco_residencia", nullable = false, unique = true, length = 60)
	public String enderecoResidencia;

	public String getEnderecoResidencia() {
		return enderecoResidencia;
	}

	public void setEnderecoResidencia(String enderecoResidencia) {
		this.enderecoResidencia = enderecoResidencia;
	}
}
