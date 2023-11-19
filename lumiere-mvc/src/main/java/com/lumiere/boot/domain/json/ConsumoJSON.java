package com.lumiere.boot.domain.json;

import java.util.Date;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lumiere.boot.domain.Consumo;

public class ConsumoJSON {
	public static String converteResidenciaParaJSON(Consumo consumo) throws Exception {
		ConsumoDomain consumoDomain = new ConsumoDomain();
		consumoDomain.setCdConsumo(consumo.getId());
		consumoDomain.setPrecoConsumo(consumo.getPrecoConsumo());
		consumoDomain.setDataConsumo(new Date(consumo.getDataConsumo()));
		consumoDomain.setFkDispositivoCdDispositivo(consumo.getDispositivo().getId());
		//Creating the ObjectMapper object
		ObjectMapper mapper = new ObjectMapper();
		//Converting the Object to JSONString
		return mapper.writeValueAsString(consumoDomain);
	}
}

class ConsumoDomain {
	private int cdConsumo;
	private double precoConsumo;
	private Date dataConsumo;
	private int fkDispositivoCdDispositivo;
	
	public int getCdConsumo() {
		return cdConsumo;
	}
	public void setCdConsumo(int cdConsumo) {
		this.cdConsumo = cdConsumo;
	}
	public double getPrecoConsumo() {
		return precoConsumo;
	}
	public void setPrecoConsumo(double precoConsumo) {
		this.precoConsumo = precoConsumo;
	}
	public Date getDataConsumo() {
		return dataConsumo;
	}
	public void setDataConsumo(Date dataConsumo) {
		this.dataConsumo = dataConsumo;
	}
	public int getFkDispositivoCdDispositivo() {
		return fkDispositivoCdDispositivo;
	}
	public void setFkDispositivoCdDispositivo(int fkDispositivoCdDispositivo) {
		this.fkDispositivoCdDispositivo = fkDispositivoCdDispositivo;
	}
}
