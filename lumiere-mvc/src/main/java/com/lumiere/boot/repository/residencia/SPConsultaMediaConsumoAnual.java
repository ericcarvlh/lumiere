package com.lumiere.boot.repository.residencia;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.procedure.ProcedureOutputs;
import org.springframework.stereotype.Repository;

import jakarta.persistence.*;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class SPConsultaMediaConsumoAnual {
	@PersistenceContext
    private EntityManager entityManager;
	
	public List<ConsultaMediaConsumoAnual> callConsultaMediaConsumoAnual(int cdResidencia) {
        StoredProcedureQuery storedProcedure = entityManager.createStoredProcedureQuery("sp_consultaMediaConsumoAnual", "MediaConsumoAnual");

        // Registre os parâmetros de entrada, se houver
        storedProcedure.registerStoredProcedureParameter("vFkResidenciaCdResidencia", Integer.class, ParameterMode.IN);
        storedProcedure.setParameter("vFkResidenciaCdResidencia", cdResidencia);
        
        // Execute a procedure
        storedProcedure.execute();
        
        List<ConsultaMediaConsumoAnual> listaMediaConsumoAnual = storedProcedure.getResultList();
        
        return listaMediaConsumoAnual;
    }
}