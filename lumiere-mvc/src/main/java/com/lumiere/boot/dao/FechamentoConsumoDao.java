package com.lumiere.boot.dao;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.hibernate.cache.spi.support.AbstractReadWriteAccess.Item;
import org.springframework.stereotype.Repository;

import com.lumiere.boot.domain.FechamentoConsumo;
import com.lumiere.boot.domain.RelatorioConsumo;

import jakarta.persistence.EntityManager;
import jakarta.persistence.ParameterMode;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.StoredProcedureQuery;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class FechamentoConsumoDao {
	@PersistenceContext
    private EntityManager entityManager;
	
	public Map<Integer, Date> consultaUltimoConsumoPorResidencia(int cdResidencia) {
        StoredProcedureQuery storedProcedure = entityManager.createStoredProcedureQuery("sp_consultaUltimoConsumoDispositivoPorResidencia", "consultaUltimoConsumoPorResidencia");

        // Registre os parâmetros de entrada, se houver
        storedProcedure.registerStoredProcedureParameter("vFkResidenciaCdResidencia", Integer.class, ParameterMode.IN);
        storedProcedure.setParameter("vFkResidenciaCdResidencia", cdResidencia);
        
        // Execute a procedure
        storedProcedure.execute();
        
        List<FechamentoConsumo> listaUltimoConsumo = storedProcedure.getResultList();
                
        Map<Integer, Date> mapFechamentoConsumo = new HashMap<>();
        for (FechamentoConsumo fechamentoConsumo: listaUltimoConsumo) {
        	mapFechamentoConsumo.put(fechamentoConsumo.getCdDispositivo(), fechamentoConsumo.getDataConsumo());
        }
        
        return mapFechamentoConsumo;
    }
}
