package com.lumiere.boot.domain.json;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lumiere.boot.domain.Residencia;

public class ResidenciaJSON {
	public static String converteResidenciaParaJSON(Residencia residencia) throws Exception {
		ResidenciaDomain residenciaDomain = new ResidenciaDomain();
		residenciaDomain.setCdResidencia(residencia.getId());
		residenciaDomain.setNomeResidencia(residencia.getNomeResidencia());
		residenciaDomain.setCepResidencia(residencia.getCepResidencia());
		residenciaDomain.setRegistroResidencia(residencia.getRegistroResidencia());
		residenciaDomain.setFkEstadoCdEstado(residencia.getEstado().getId());
		residenciaDomain.setFkUsuarioCdUsuario(residencia.getUsuario().getId());
		residenciaDomain.setFkIconeResidenciaCdIcone(residencia.getIconeResidencia().getId());
		//Creating the ObjectMapper object
		ObjectMapper mapper = new ObjectMapper();
		//Converting the Object to JSONString
		return mapper.writeValueAsString(residenciaDomain);
	} 
}	

class ResidenciaDomain {
	private int cdResidencia;
	private String registroResidencia;
	private String nomeResidencia;
	private String cepResidencia;
	private int fkIconeResidenciaCdIcone;
	private int fkEstadoCdEstado;
	private int fkUsuarioCdUsuario;
	
	public int getCdResidencia() {
		return cdResidencia;
	}
	public void setCdResidencia(int cdResidencia) {
		this.cdResidencia = cdResidencia;
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
	public String getCepResidencia() {
		return cepResidencia;
	}
	public void setCepResidencia(String cepResidencia) {
		this.cepResidencia = cepResidencia;
	}
	public int getFkIconeResidenciaCdIcone() {
		return fkIconeResidenciaCdIcone;
	}
	public void setFkIconeResidenciaCdIcone(int fkIconeResidenciaCdIcone) {
		this.fkIconeResidenciaCdIcone = fkIconeResidenciaCdIcone;
	}
	public int getFkEstadoCdEstado() {
		return fkEstadoCdEstado;
	}
	public void setFkEstadoCdEstado(int fkEstadoCdEstado) {
		this.fkEstadoCdEstado = fkEstadoCdEstado;
	}
	public int getFkUsuarioCdUsuario() {
		return fkUsuarioCdUsuario;
	}
	public void setFkUsuarioCdUsuario(int fkUsuarioCdUsuario) {
		this.fkUsuarioCdUsuario = fkUsuarioCdUsuario;
	}
}