package com.lumiere.boot.repository.residencia;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.procedure.ProcedureOutputs;
import org.springframework.stereotype.Repository;

import com.lumiere.boot.domain.API.ConsumoAPI;

import jakarta.persistence.*;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class ConsumoAPIDAO {
	@PersistenceContext
    private EntityManager entityManager;
	
	public List<ConsumoAPI> callConsultaMediaConsumoAnual(int cdResidencia) {
        StoredProcedureQuery storedProcedure = entityManager.createStoredProcedureQuery("sp_consultaMediaConsumoAnual", "MediaConsumoAnual");

        // Registre os parâmetros de entrada, se houver
        storedProcedure.registerStoredProcedureParameter("vFkResidenciaCdResidencia", Integer.class, ParameterMode.IN);
        storedProcedure.setParameter("vFkResidenciaCdResidencia", cdResidencia);
        
        // Execute a procedure
        storedProcedure.execute();
        
        List<ConsumoAPI> listaMediaConsumoAnual = storedProcedure.getResultList();
        
        return listaMediaConsumoAnual;
    }
	
	public List<ConsumoAPI> callConsultaConsumoTotalPorDispositivo(int cdResidencia) {
        StoredProcedureQuery storedProcedure = entityManager.createStoredProcedureQuery("sp_consultaConsumoTotalPorDispositivo", "consumoTotalPorDispositivo");

        // Registre os parâmetros de entrada, se houver
        storedProcedure.registerStoredProcedureParameter("vFkResidenciaCdResidencia", Integer.class, ParameterMode.IN);
        storedProcedure.setParameter("vFkResidenciaCdResidencia", cdResidencia);
        
        // Execute a procedure
        storedProcedure.execute();
        
        List<ConsumoAPI> listaConsumoPorDispositivo = storedProcedure.getResultList();
        
        return listaConsumoPorDispositivo;
    }
}