package com.lumiere.boot.repository.residencia;

import jakarta.persistence.*;

@SqlResultSetMapping(
        name = "MediaConsumoAnual",
        classes = @ConstructorResult(
                targetClass = ConsultaMediaConsumoAnual.class,
                columns = {
                    @ColumnResult(name = "ano", type = Integer.class),
                    @ColumnResult(name = "consumoTotal", type = Double.class)
        })
)
@Entity
public class ConsultaMediaConsumoAnual {
	@Id
    private int ano;
    private double consumoTotal;

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	public double getConsumoTotal() {
		return consumoTotal;
	}

	public void setConsumoTotal(double consumoTotal) {
		this.consumoTotal = consumoTotal;
	}
}
