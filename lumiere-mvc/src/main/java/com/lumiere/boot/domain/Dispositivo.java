package com.lumiere.boot.domain;

import java.util.List;

import jakarta.persistence.*;

@SuppressWarnings("serial")
@Entity()
@Table(name = "DISPOSITIVO")
public class Dispositivo extends AbstractEntity<Long> {
	
	/*
	 * hello it's 'f' world
	 * 
	*/

	@Column(name = "KWh_dispositivo", nullable = false)
	private double KWhDispositivo; 
	
	public double getKWhDispositivo() {
		return KWhDispositivo;
	}

	public void setKWhDispositivo(double kWhDispositivo) {
		KWhDispositivo = kWhDispositivo;
	}

	@Column(name = "nome_dispositivo", nullable = false)
	private String nomeDispositivo;
	
	public String getNomeDispositivo() {
		return nomeDispositivo;
	}

	public void setNomeDispositivo(String nomeDispositivo) {
		this.nomeDispositivo = nomeDispositivo;
	}

	@ManyToOne
	@JoinColumn(name = "fk_Residencia_cd_residencia")
	private Residencia residencia;

	public Residencia getResidencia() {
		return residencia;
	}

	public void setResidencia(Residencia residencia) {
		this.residencia = residencia;
	}
	
	@OneToMany(mappedBy = "dispositivo")
	private List<Consumo> consumo;

	public List<Consumo> getConsumo() {
		return consumo;
	}

	public void setConsumo(List<Consumo> consumo) {
		this.consumo = consumo;
	}
	
}
