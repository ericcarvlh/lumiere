package com.lumiere.boot.domain;

import java.util.List;

import jakarta.persistence.*;

@SuppressWarnings("serial")
@Entity
@Table(name = "RESIDENCIA")
public class Residencia extends AbstractEntity<Long> {

	@Column(name = "registro_residencia", nullable = false, unique = true, length = 20)
	private String registroResidencia;

	public String getRegistroResidencia() {
		return registroResidencia;
	}

	public void setRegistroResidencia(String registroResidencia) {
		this.registroResidencia = registroResidencia;
	}
	
	@Column(name = "nome_residencia", nullable = false, unique = true, length = 60)
	private String nomeResidencia;

	public String getNomeResidencia() {
		return nomeResidencia;
	}

	public void setNomeResidencia(String nomeResidencia) {
		this.nomeResidencia = nomeResidencia;
	}
	
	@Column(name = "endereco_residencia", nullable = false, unique = true, length = 100)
	public String enderecoResidencia;

	public String getEnderecoResidencia() {
		return enderecoResidencia;
	}

	public void setEnderecoResidencia(String enderecoResidencia) {
		this.enderecoResidencia = enderecoResidencia;
	}
	
	@ManyToOne
	@JoinColumn(name = "fk_Estado_cd_estado")
	private Estado estado;

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}
	
	@ManyToOne
	@JoinColumn(name = "fk_Usuario_cd_usuario")
	private Usuario usuario;

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	@OneToMany(mappedBy = "residencia")
	private List<Dispositivo> dispositivo;

	public List<Dispositivo> getDispositivo() {
		return dispositivo;
	}

	public void setDispositivo(List<Dispositivo> dispositivo) {
		this.dispositivo = dispositivo;
	}
	
	
	
	
	
}
