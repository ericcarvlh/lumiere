package com.lumiere.boot.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "Icone_Residencia")
public class IconeResidencia extends AbstractEntity<Integer> {
	@Column(name = "cd_icone")
	public int cdIcone;
	
	@Column(name = "url_icone", nullable = false)
	public String urlIcone;

	public IconeResidencia() {}
	
    public IconeResidencia(int cdIcone, String urlIcone) {
        setId(cdIcone);
        this.urlIcone = urlIcone;
    }
	
	public String getUrlIcone() {
		return urlIcone;
	}

	public void setUrlIcone(String urlIcone) {
		this.urlIcone = urlIcone;
	}
}
