package com.lumiere.boot.domain;

import jakarta.persistence.*;

@SqlResultSetMapping(
        name = "rankingConsumidor",
        classes = @ConstructorResult(
                targetClass = RankingConsumidor.class,
                columns = {
                    @ColumnResult(name = "consumoTotal", type = Double.class)
        })
)
@Entity
public class RankingConsumidor {
	@Id
	private int id;
	
	@Column(name = "ano")
    private int ano;
	
	@Column(name = "nomeDispositivo")
    private String nomeDispositivo;

	@Column(name = "consumoTotal")
	private double consumoTotal;
}
