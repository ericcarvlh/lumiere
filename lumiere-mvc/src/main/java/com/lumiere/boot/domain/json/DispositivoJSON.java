package com.lumiere.boot.domain.json;

import java.util.Date;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lumiere.boot.domain.Dispositivo;

public class DispositivoJSON {
	public static String converteResidenciaParaJSON(Dispositivo dispositivo) throws Exception {
		DispositivoDomain dispositivoDomain = new DispositivoDomain();
		dispositivoDomain.setCdDispositivo(dispositivo.getId());
		dispositivoDomain.setWattsDispositivo(dispositivo.getWattsDispositivo());
		dispositivoDomain.setNomeDispositivo(dispositivo.getNomeDispositivo());
		dispositivoDomain.setFkResidenciaCdResidencia(dispositivo.getResidencia().getId());
		dispositivoDomain.setFkTipoDispositivoCdTipoDispositivo(dispositivo.getTipoDispositivo().getId());
		//Creating the ObjectMapper object
		ObjectMapper mapper = new ObjectMapper();
		//Converting the Object to JSONString
		return mapper.writeValueAsString(dispositivoDomain);
	}
}

class DispositivoDomain {
	private int cdDispositivo;
	private double wattsDispositivo;
	private String nomeDispositivo;
	private int tempoDeConsumoDiario;
	private int fkResidenciaCdResidencia;
	private int fkTipoDispositivoCdTipoDispositivo;
	
	public int getCdDispositivo() {
		return cdDispositivo;
	}
	public void setCdDispositivo(int cdDispositivo) {
		this.cdDispositivo = cdDispositivo;
	}
	public double getWattsDispositivo() {
		return wattsDispositivo;
	}
	public void setWattsDispositivo(double wattsDispositivo) {
		this.wattsDispositivo = wattsDispositivo;
	}
	public String getNomeDispositivo() {
		return nomeDispositivo;
	}
	public void setNomeDispositivo(String nomeDispositivo) {
		this.nomeDispositivo = nomeDispositivo;
	}
	public int getTempoDeConsumoDiario() {
		return tempoDeConsumoDiario;
	}
	public void setTempoDeConsumoDiario(int tempoDeConsumoDiario) {
		this.tempoDeConsumoDiario = tempoDeConsumoDiario;
	}
	public int getFkResidenciaCdResidencia() {
		return fkResidenciaCdResidencia;
	}
	public void setFkResidenciaCdResidencia(int fkResidenciaCdResidencia) {
		this.fkResidenciaCdResidencia = fkResidenciaCdResidencia;
	}
	public int getFkTipoDispositivoCdTipoDispositivo() {
		return fkTipoDispositivoCdTipoDispositivo;
	}
	public void setFkTipoDispositivoCdTipoDispositivo(int fkTipoDispositivoCdTipoDispositivo) {
		this.fkTipoDispositivoCdTipoDispositivo = fkTipoDispositivoCdTipoDispositivo;
	}
}