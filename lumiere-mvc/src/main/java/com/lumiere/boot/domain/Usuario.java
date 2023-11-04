package com.lumiere.boot.domain;

import java.util.Date;
import java.util.List;

import jakarta.persistence.*;

@SuppressWarnings("serial")
@Entity()
@Table(name = "USUARIO")
public class Usuario extends AbstractEntity<Integer> {
	
	/*
	 * oh cheirei as cinzas da tua vo
	 * 
	*/
	
	@Column(name = "cd_usuario")
	private int cdUsuario;
	
	@Column(name = "senha_usuario", nullable = false)
    private String senhaUsuario;

	@Column(name = "nome_usuario", nullable = false)
    private String nomeUsuario;
	
	@Column(name = "data_de_cadastro", nullable = false)
	private Date dataDeCadastro;
	
	@Column(name = "email_usuario", nullable = false)
    private String emailUsuario;
	
	@OneToMany(mappedBy = "usuario")
	private List<Residencia> residencias;
	
    public Usuario(int cdUsuario, String nomeUsuario, String emailUsuario, String senhaUsuario) {
        setId(cdUsuario);
        this.nomeUsuario = nomeUsuario;
        this.emailUsuario = emailUsuario;
        this.senhaUsuario = senhaUsuario;
    }
    
    public Usuario() {
    	
    }
	
	public String getNomeUsuario() {
		return nomeUsuario;
	}

	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}

	public String getEmailUsuario() {
		return emailUsuario;
	}

	public void setEmailUsuario(String emailUsuario) {
		this.emailUsuario = emailUsuario;
	}
    
	public String getSenhaUsuario() {
		return senhaUsuario;
	}

	public void setSenhaUsuario(String senhaUsuario) {
		this.senhaUsuario = senhaUsuario;
	}
	
	public Date getDataDeCadastro() {
		return dataDeCadastro;
	}

	public void setDataDeCadastro(Date dataDeCadastro) {
		this.dataDeCadastro = dataDeCadastro;
	}

	public List<Residencia> getResidencias() {
		return residencias;
	}

	public void setResidencias(List<Residencia> residencias) {
		this.residencias = residencias;
	}
	
	
}
