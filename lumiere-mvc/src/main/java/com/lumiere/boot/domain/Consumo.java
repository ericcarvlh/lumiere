package com.lumiere.boot.domain;


import java.text.SimpleDateFormat;
import java.util.Date;
import jakarta.persistence.*;

@Entity
@Table(name = "CONSUMO")
public class Consumo {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cd_consumo")
	private Integer cdConsumo;
	
	@Column(name = "preco_consumo", nullable = false)
	private double precoConsumo;
	
	@Column(name = "kwh_consumo", nullable = false)
	private double kwhConsumo;

	@Column(name = "data_consumo", nullable = false)
	private Date dataConsumo;
	
	@ManyToOne
	@JoinColumn(name = "fk_Dispositivo_cd_dispositivo")
	private Dispositivo dispositivo;

	public double getKwhConsumo() {
		return kwhConsumo;
	}

	public void setKwhConsumo(double kwhConsumo) {
		this.kwhConsumo = kwhConsumo;
	}
	
	public String getDataConsumo() {
		String dataFormatada = new SimpleDateFormat("dd/MM/yyyy").format(dataConsumo);
		return dataFormatada;
	}
	
	public double getPrecoConsumo() {
		return precoConsumo;
	}
	
	public void setPrecoConsumo(double precoConsumo) {
		this.precoConsumo = precoConsumo;
	}
	
	public void setDataConsumo(Date dataConsumo) {
		this.dataConsumo = dataConsumo;
	}
	
	public Integer getId() {
		return cdConsumo;
	}

	public void setId(Integer id) {
		this.cdConsumo = id;
	}
	
	public Dispositivo getDispositivo() {
		return dispositivo;
	}

	public void setDispositivo(Dispositivo dispositivo) {
		this.dispositivo = dispositivo;
	}
	
	
	
}
