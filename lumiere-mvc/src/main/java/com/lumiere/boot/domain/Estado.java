package com.lumiere.boot.domain;

import java.util.List;

import jakarta.persistence.*;

@SuppressWarnings("serial")
@Entity
@Table(name = "ESTADO")
public class Estado extends AbstractEntity<Long> {

	@Column(name = "nome_estado", nullable = false, unique = true, length = 40)
	private String nomeEstado;

	public String getNomeEstado() {
		return nomeEstado;
	}

	public void setNomeEstado(String nomeEstado) {
		this.nomeEstado = nomeEstado;
	}
	
	@Column(name = "UF_estado", nullable = false, unique = true, length = 2)
	private String UfEstado;

	public String getUfEstado() {
		return UfEstado;
	}

	public void setUfEstado(String ufEstado) {
		UfEstado = ufEstado;
	}
	
	@Column(name = "preco_KWH", nullable = false, unique = true)
	private double precoKwh;
	
	public double getPrecoKwh() {
		return precoKwh;
	}

	public void setPrecoKwh(double precoKwh) {
		this.precoKwh = precoKwh;
	}

	@OneToMany(mappedBy = "estado")
	private List<Residencia> residencias;

	public List<Residencia> getResidencias() {
		return residencias;
	}

	public void setResidencias(List<Residencia> residencias) {
		this.residencias = residencias;
	}
	
}
