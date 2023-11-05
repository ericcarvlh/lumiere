package com.lumiere.boot.domain;

import java.util.List;

import jakarta.persistence.*;

@SuppressWarnings("serial")
@Entity
@Table(name = "RESIDENCIA")
public class Residencia extends AbstractEntity<Long> {

	@Column(name = "registro_residencia", nullable = false, length = 20)
	private String registroResidencia;
	
	@Column(name = "nome_residencia", nullable = false, length = 60)
	private String nomeResidencia;

	@Column(name = "cep_residencia", nullable = false, length = 8)
	private String cepResidencia;
	
	@ManyToOne
	@JoinColumn(name = "fk_Estado_cd_estado")
	private Estado estado;
	
	@ManyToOne
	@JoinColumn(name = "fk_Usuario_cd_usuario")
	private Usuario usuario;
	
	@ManyToOne
	@JoinColumn(name = "fk_Icone_Residencia_cd_icone")
	private IconeResidencia iconeResidencia;
	
	@OneToMany(mappedBy = "residencia")
	private List<Dispositivo> dispositivo;
	
	public String getCepResidencia() {
		return cepResidencia;
	}

	public void setCepResidencia(String cepResidencia) {
		this.cepResidencia = cepResidencia;
	}
	
	public String getRegistroResidencia() {
		return registroResidencia;
	}

	public void setRegistroResidencia(String registroResidencia) {
		this.registroResidencia = registroResidencia;
	}

	public String getNomeResidencia() {
		return nomeResidencia;
	}

	public void setNomeResidencia(String nomeResidencia) {
		this.nomeResidencia = nomeResidencia;
	}
	
	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<Dispositivo> getDispositivo() {
		return dispositivo;
	}

	public void setDispositivo(List<Dispositivo> dispositivo) {
		this.dispositivo = dispositivo;
	}
	
	public IconeResidencia getIconeResidencia() {
		return iconeResidencia;
	}

	public void setIconeResidencia(IconeResidencia iconeResidencia) {
		this.iconeResidencia = iconeResidencia;
	}
}
