package com.lumiere.boot.domain;

import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name = "ESTADO")
public class Estado {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cd_estado")
	private Integer cdEstado;
	
	@Column(name = "UF_estado", nullable = false, unique = true, length = 2)
	private String UFEstado;

	@Column(name = "nome_estado", nullable = false, unique = true, length = 40)
	private String nomeEstado;
	
	@OneToMany(mappedBy = "estado")
	private List<Residencia> residencias;
	
	@Column(name = "preco_KWH", nullable = false, unique = true)
	private double precoKwh;

	public Estado () {}
	
	public Estado (int cdEstado, String UFEstado) {
		setId(cdEstado);
		this.UFEstado = UFEstado;
	}
	
	public Integer getId() {
		return cdEstado;
	}

	public void setId(Integer id) {
		this.cdEstado = id;
	}
	
	public String getNomeEstado() {
		return nomeEstado;
	}

	public void setNomeEstado(String nomeEstado) {
		this.nomeEstado = nomeEstado;
	}

	public String getUFEstado() {
		return UFEstado;
	}

	public void setUFEstado(String UFEstado) {
		this.UFEstado = UFEstado;
	}
	
	public double getPrecoKwh() {
		return precoKwh;
	}

	public void setPrecoKwh(double precoKwh) {
		this.precoKwh = precoKwh;
	}

	public List<Residencia> getResidencias() {
		return residencias;
	}

	public void setResidencias(List<Residencia> residencias) {
		this.residencias = residencias;
	}
	
}
