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

	@Column(name = "endereco_residencia", nullable = false, length = 100)
	private String enderecoResidencia;
	
	@Column(name = "cidade_residencia", nullable = false, length = 100)
	private String cidadeResidencia;
	
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

	public String getEnderecoResidencia() {
		return enderecoResidencia;
	}

	public void setEnderecoResidencia(String enderecoResidencia) {
		this.enderecoResidencia = enderecoResidencia;
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
	
	
	
	
	
}
