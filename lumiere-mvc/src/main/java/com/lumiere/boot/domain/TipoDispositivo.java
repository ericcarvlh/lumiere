package com.lumiere.boot.domain;

import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name = "TIPO_DISPOSITIVO")
public class TipoDispositivo  {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cd_tipo_dispositivo")
	private Integer cdTipoDispositivo;
	
	@Column(name = "tipo_dispositivo", nullable = false, length = 60)
	private String tipoDispositivo;

	@OneToMany(mappedBy = "tipoDispositivo")
	private List<Dispositivo> dispositivo;
	
	public Integer getId() {
		return cdTipoDispositivo;
	}

	public void setId(Integer id) {
		this.cdTipoDispositivo = id;
	}
	
	public String getTipoDispositivo() {
		return tipoDispositivo;
	}

	public void setTipoDispositivo(String tipoDispositivo) {
		this.tipoDispositivo = tipoDispositivo;
	}
}
