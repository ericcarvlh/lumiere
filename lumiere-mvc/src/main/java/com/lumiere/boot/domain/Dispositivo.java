package com.lumiere.boot.domain;

import java.util.List;

import jakarta.persistence.*;

@SuppressWarnings("serial")
@Entity
@Table(name = "DISPOSITIVO")
public class Dispositivo extends AbstractEntity<Long> {
	
	/*
	 * hello it's 'f' world
	 * 
	*/

	@Column(name = "KWh_dispositivo", nullable = false)
	private double KWhDispositivo; 
	
	@Column(name = "nome_dispositivo", nullable = false)
	private String nomeDispositivo;
	
	@Column(name = "tempo_de_uso_diario", nullable = false)
	private int tempoUsoDiario;
	
	@ManyToOne
	@JoinColumn(name = "fk_Residencia_cd_residencia")
	private Residencia residencia;
	
	@ManyToOne
	@JoinColumn(name = "fk_tipo_dispositivo_cd_tipo_dispositivo")
	private TipoDispositivo tipoDispositivo;
	
	@OneToMany(mappedBy = "dispositivo")
	private List<Consumo> consumo;
	
	public int getTempoUsoDiario() {
		return tempoUsoDiario;
	}
	
	public void setTempoUsoDiario(int tempoUsoDiario) {
		this.tempoUsoDiario = tempoUsoDiario;
	}
	
	public double getKWhDispositivo() {
		return KWhDispositivo;
	}

	public void setKWhDispositivo(double kWhDispositivo) {
		KWhDispositivo = kWhDispositivo;
	}
	
	public String getNomeDispositivo() {
		return nomeDispositivo;
	}

	public void setNomeDispositivo(String nomeDispositivo) {
		this.nomeDispositivo = nomeDispositivo;
	}

	public TipoDispositivo getTipoDispositivo() {
		return tipoDispositivo;
	}

	public void setTipoDispositivo(TipoDispositivo tipoDispositivo) {
		this.tipoDispositivo = tipoDispositivo;
	}

	public Residencia getResidencia() {
		return residencia;
	}

	public void setResidencia(Residencia residencia) {
		this.residencia = residencia;
	}

	public List<Consumo> getConsumo() {
		return consumo;
	}

	public void setConsumo(List<Consumo> consumo) {
		this.consumo = consumo;
	}
	
}
