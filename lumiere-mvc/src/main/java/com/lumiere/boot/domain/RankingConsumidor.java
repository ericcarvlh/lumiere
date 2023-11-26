package com.lumiere.boot.domain;

import jakarta.persistence.*;

@SqlResultSetMapping(
        name = "rankingConsumidor",
        classes = @ConstructorResult(
                targetClass = RankingConsumidor.class,
                columns = {
                    @ColumnResult(name = "cdUsuario", type = Integer.class),
                    @ColumnResult(name = "nomeUsuario", type = String.class),
                    @ColumnResult(name = "totalKWhMes", type = Double.class),
                    @ColumnResult(name = "mesFechamento", type = Integer.class)
        })
)
@Entity
public class RankingConsumidor {
	@Id
	private int id;
	
	@Column(name = "cdUsuario")
	private int cdUsuario;
	
	@Column(name = "nomeUsuario")
	private String nomeUsuario;
	
	@Column(name = "totalKWhMes")
	private double totalKWhMes;
	
	@Column(name = "mesFechamento")
	private int mesFechamento;
	
	public int getCdUsuario() {
		return cdUsuario;
	}

	public void setCdUsuario(int cdUsuario) {
		this.cdUsuario = cdUsuario;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNomeUsuario() {
		return nomeUsuario;
	}

	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}

	public double getTotalKWhMes() {
		return totalKWhMes;
	}

	public void setTotalKWhMes(double totalKWhMes) {
		this.totalKWhMes = totalKWhMes;
	}

	public int getMesFechamento() {
		return mesFechamento;
	}

	public void setMesFechamento(int mesFechamento) {
		this.mesFechamento = mesFechamento;
	}
}
