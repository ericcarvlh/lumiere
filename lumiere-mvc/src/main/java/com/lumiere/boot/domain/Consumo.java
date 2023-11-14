package com.lumiere.boot.domain;


import java.util.Date;
import jakarta.persistence.*;

@Entity
@Table(name = "CONSUMO")
public class Consumo {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cd_consumo")
	private Integer cdConsumo;

	public Integer getId() {
		return cdConsumo;
	}

	public void setId(Integer id) {
		this.cdConsumo = id;
	}
	
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
