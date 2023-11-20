package com.lumiere.boot.domain;

import jakarta.persistence.*;

@SqlResultSetMapping(
        name = "rankingConsumidor",
        classes = @ConstructorResult(
                targetClass = RankingConsumidor.class,
                columns = {
                    @ColumnResult(name = "", type = Double.class)
        })
)
@Entity
public class RankingConsumidor {
	@Id
	private int id;
	
	
}
