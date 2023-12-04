package com.lumiere.boot.domain;


import java.sql.Date;

import jakarta.persistence.*;


@SqlResultSetMapping(
	    name = "consultaUltimoConsumoPorResidencia",
	    classes = @ConstructorResult(
	        targetClass = FechamentoConsumo.class,
	        columns = {
	            @ColumnResult(name = "cdDispositivo", type = Integer.class),
	            @ColumnResult(name = "ultimoConsumo", type = Date.class),
	        }
	    )
	)
@Entity
public class FechamentoConsumo {
	@Id
	private int id;

	@Column(name="cdDispositivo")
	private int cdDispositivo;
	
	@Column(name="ultimoConsumo")
	private Date ultimoConsumo;

	public int getCdDispositivo() {
		return cdDispositivo;
	}

	public void setCdDispositivo(int cdDispositivo) {
		this.cdDispositivo = cdDispositivo;
	}

	public Date getDataConsumo() {
		return ultimoConsumo;
	}

	public void setDataConsumo(Date dataConsumo) {
		this.ultimoConsumo = dataConsumo;
	}
}
