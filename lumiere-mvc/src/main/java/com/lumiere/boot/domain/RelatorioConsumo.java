package com.lumiere.boot.domain;

import jakarta.persistence.*;

@SqlResultSetMapping(
        name = "MediaConsumoAnual",
        classes = @ConstructorResult(
                targetClass = RelatorioConsumo.class,
                columns = {
                    @ColumnResult(name = "ano", type = Integer.class),
                    @ColumnResult(name = "consumoTotal", type = Double.class)
        })
)
@SqlResultSetMapping(
        name = "consumoTotalPorDispositivo",
        classes = @ConstructorResult(
                targetClass = RelatorioConsumo.class,
                columns = {
                    @ColumnResult(name = "nomeDispositivo", type = String.class),
                    @ColumnResult(name = "consumoTotal", type = Double.class)
        })
)
@SqlResultSetMapping(
        name = "faturaAtual",
        classes = @ConstructorResult(
                targetClass = RelatorioConsumo.class,
                columns = {
                    @ColumnResult(name = "consumoTotal", type = Double.class)
        })
)
@SqlResultSetMapping(
        name = "consumoMedio",
        classes = @ConstructorResult(
                targetClass = RelatorioConsumo.class,
                columns = {
                    @ColumnResult(name = "consumoTotal", type = Double.class)
        })
)
@Entity
public class RelatorioConsumo {
	@Id
	private int id;
	
	@Column(name = "ano")
    private int ano;
	
	@Column(name = "nomeDispositivo")
    private String nomeDispositivo;

	@Column(name = "consumoTotal")
	private double consumoTotal;

    public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNomeDispositivo() {
		return nomeDispositivo;
	}

	public void setNomeDispositivo(String nomeDispositivo) {
		this.nomeDispositivo = nomeDispositivo;
	}

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
