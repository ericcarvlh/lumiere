package com.lumiere.boot.domain;

import java.text.SimpleDateFormat;
import java.util.Date;

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
@SqlResultSetMapping(
        name = "relatorioPorPeriodo",
        classes = @ConstructorResult(
                targetClass = RelatorioConsumo.class,
                columns = {
                	@ColumnResult(name = "dataInicial", type = Date.class),
                	@ColumnResult(name = "consumoMedioKWh", type = Double.class),
                    @ColumnResult(name = "consumoTotalKWh", type = Double.class),
                    @ColumnResult(name = "valorTotal", type = Double.class),
                    @ColumnResult(name = "dataFinal", type = Date.class)
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
	
	@Column(name = "consumoMedioKWh")
	private double consumoMedioKWh;
	
	@Column(name = "dataInicial")
	private Date dataInicial;
	
	@Column(name = "dataFinal")
	private Date dataFinal;

	@Column(name = "consumoTotalKWh")
	private double consumoTotalKWh;
	
	@Column(name = "consumoTotal")
	private double consumoTotal;
	
	@Column(name = "valorTotal")
	private double valorTotal;

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
	
	public double getConsumoMedioKWh() {
		return consumoMedioKWh;
	}

	public void setConsumoMedioKWh(double consumoMedioKWh) {
		this.consumoMedioKWh = consumoMedioKWh;
	}

	public String getDataInicial() {
		String dataFormatada = new SimpleDateFormat("dd/MM/yyyy").format(dataInicial);
		return dataFormatada;
	}

	public void setDataInicial(Date dataInicial) {
		this.dataInicial = dataInicial;
	}

	public String getDataFinal() {
		String dataFormatada = new SimpleDateFormat("dd/MM/yyyy").format(dataFinal);
		return dataFormatada;
	}

	public void setDataFinal(Date dataFinal) {
		this.dataFinal = dataFinal;
	}

	public double getConsumoTotalKWh() {
		return consumoTotalKWh;
	}

	public void setConsumoTotalKWh(double consumoTotalKWh) {
		this.consumoTotalKWh = consumoTotalKWh;
	}

	public double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(double valorTotal) {
		this.valorTotal = valorTotal;
	}
}
