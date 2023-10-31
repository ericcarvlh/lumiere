package com.lumiere.boot.domain;

import java.sql.Date;
import jakarta.persistence.*;

@SuppressWarnings("serial")
@Entity()
@Table(name = "CONSUMO")
public class Consumo extends AbstractEntity<Long> {
	
	@Column(name = "preco_consumo", nullable = false)
	private double precoConsumo;
	
	public double getPrecoConsumo() {
		return precoConsumo;
	}
	
	public void setPrecoConsumo(double precoConsumo) {
		this.precoConsumo = precoConsumo;
	}
	
	@Column(name = "data_consumo", nullable = false)
	private Date dataConsumo;
	
	public Date getDataConsumo() {
		return dataConsumo;
	}
	
	public void setDataConsumo(Date dataConsumo) {
		this.dataConsumo = dataConsumo;
	}
	
	@Column(name = "tempo_de_consumo_diario", nullable = false)
	private int tempoDeConsumo;
	
	public int getTempoDeConsumo() {
		return tempoDeConsumo;
	}
	
	public void setTempoDeConsumo(int tempoDeConsumo) {
		this.tempoDeConsumo = tempoDeConsumo;
	}
	
	@ManyToOne
	@JoinColumn(name = "fk_Dispositivo_cd_dispositivo")
	private Dispositivo dispositivo;

	public Dispositivo getDispositivo() {
		return dispositivo;
	}

	public void setDispositivo(Dispositivo dispositivo) {
		this.dispositivo = dispositivo;
	}
	
	
	
}
