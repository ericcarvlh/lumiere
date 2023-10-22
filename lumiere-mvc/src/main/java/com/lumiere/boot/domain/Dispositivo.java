package com.lumiere.boot.domain;

import jakarta.persistence.*;

@SuppressWarnings("serial")
@Entity()
@Table(name = "DISPOSITIVO")
public class Dispositivo extends AbstractEntity<Long> {
	@Column(name = "KWh_dispositivo")
	private double KWhDispositivo; 
	
	public double getKWhDispositivo() {
		return KWhDispositivo;
	}

	public void setKWhDispositivo(double kWhDispositivo) {
		KWhDispositivo = kWhDispositivo;
	}

	@Column(name = "nome_dispositivo")
	private String nomeDispositivo;
	
	public String getNomeDispositivo() {
		return nomeDispositivo;
	}

	public void setNomeDispositivo(String nomeDispositivo) {
		this.nomeDispositivo = nomeDispositivo;
	}

}
