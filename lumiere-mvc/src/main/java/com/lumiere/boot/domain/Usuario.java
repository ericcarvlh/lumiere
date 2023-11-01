package com.lumiere.boot.domain;

import java.util.Date;
import java.util.List;

import jakarta.persistence.*;

@SuppressWarnings("serial")
@Entity()
@Table(name = "USUARIO")
public class Usuario extends AbstractEntity<Long> {
	
	/*
	 * oh cheirei as cinzas da tua vo
	 * 
	*/

	@Column(name = "nome_usuario", nullable = false)
    private String nomeUsuario;
   
	public String getNomeUsuario() {
		return nomeUsuario;
	}

	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}
    
	@Column(name = "email_usuario", nullable = false)
    private String emailUsuario;

	public String getEmailUsuario() {
		return emailUsuario;
	}

	public void setEmailUsuario(String emailUsuario) {
		this.emailUsuario = emailUsuario;
	}

	@Column(name = "senha_usuario", nullable = false)
    private String senhaUsuario;
    
	public String getSenhaUsuario() {
		return senhaUsuario;
	}

	public void setSenhaUsuario(String senhaUsuario) {
		this.senhaUsuario = senhaUsuario;
	}
	
	@Column(name = "data_de_cadastro", nullable = false)
	private Date dataDeCadastro;
	
	public Date getDataDeCadastro() {
		return dataDeCadastro;
	}

	public void setDataDeCadastro(Date dataDeCadastro) {
		this.dataDeCadastro = dataDeCadastro;
	}
	
	@OneToMany(mappedBy = "usuario")
	private List<Residencia> residencias;

	public List<Residencia> getResidencias() {
		return residencias;
	}

	public void setResidencias(List<Residencia> residencias) {
		this.residencias = residencias;
	}
	
	@ManyToOne
	@JoinColumn(name = "fk_Residencia_cd_residencia")
	private Residencia residencia;

	public Residencia getResidencia() {
		return residencia;
	}

	public void setResidencia(Residencia residencia) {
		this.residencia = residencia;
	}
	
}
