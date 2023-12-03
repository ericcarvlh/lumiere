package com.lumiere.boot.domain;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "Icone_Residencia")
public class IconeResidencia {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cd_icone")
	private Integer cdIcone;
		
	@Column(name = "url_icone", nullable = false)
	private String urlIcone;
	
	@OneToMany(mappedBy = "iconeResidencia")
	private List<Residencia> residencias;
	
	public String getUrlIcone() {
		return urlIcone;
	}

	public void setUrlIcone(String urlIcone) {
		this.urlIcone = urlIcone;
	}
	
	public Integer getId() {
		return cdIcone;
	}

	public void setId(Integer id) {
		this.cdIcone = id;
	}
}
