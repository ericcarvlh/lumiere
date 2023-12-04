package com.lumiere.boot.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.lumiere.boot.domain.RankingConsumidor;

import jakarta.persistence.*;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class RankingConsumidorDao {
	@PersistenceContext
    private EntityManager entityManager;
	
	public List<RankingConsumidor> callConsultaRankingConsumidor() {
        StoredProcedureQuery storedProcedure = entityManager.createStoredProcedureQuery("sp_consultaRankingConsumidor", "rankingConsumidor");
        
        // Execute a procedure
        storedProcedure.execute();
        
        List<RankingConsumidor> listaRankingConsumidor = storedProcedure.getResultList();
                
        return listaRankingConsumidor;
    }
}
