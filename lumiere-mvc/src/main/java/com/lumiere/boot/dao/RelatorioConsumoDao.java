package com.lumiere.boot.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.lumiere.boot.domain.RelatorioConsumo;

import jakarta.persistence.*;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class RelatorioConsumoDao {
	@PersistenceContext
    private EntityManager entityManager;
	
	public List<RelatorioConsumo> callConsultaMediaConsumoAnual(int cdResidencia) {
        StoredProcedureQuery storedProcedure = entityManager.createStoredProcedureQuery("sp_consultaMediaConsumoAnual", "MediaConsumoAnual");

        // Registre os parâmetros de entrada, se houver
        storedProcedure.registerStoredProcedureParameter("vFkResidenciaCdResidencia", Integer.class, ParameterMode.IN);
        storedProcedure.setParameter("vFkResidenciaCdResidencia", cdResidencia);
        
        // Execute a procedure
        storedProcedure.execute();
        
        List<RelatorioConsumo> listaMediaConsumoAnual = storedProcedure.getResultList();
        
        return listaMediaConsumoAnual;
    }
	
	public List<RelatorioConsumo> callConsultaConsumoTotalPorDispositivo(int cdResidencia) {
        StoredProcedureQuery storedProcedure = entityManager.createStoredProcedureQuery("sp_consultaConsumoTotalPorDispositivo", "consumoTotalPorDispositivo");

        // Registre os parâmetros de entrada, se houver
        storedProcedure.registerStoredProcedureParameter("vFkResidenciaCdResidencia", Integer.class, ParameterMode.IN);
        storedProcedure.setParameter("vFkResidenciaCdResidencia", cdResidencia);
        
        // Execute a procedure
        storedProcedure.execute();
        
        List<RelatorioConsumo> listaConsumoPorDispositivo = storedProcedure.getResultList();
        
        return listaConsumoPorDispositivo;
    }
	
	public RelatorioConsumo callConsultaFaturaAtual(int cdResidencia) {
        StoredProcedureQuery storedProcedure = entityManager.createStoredProcedureQuery("sp_consultaFaturaAtual", "faturaAtual");

        // Registre os parâmetros de entrada, se houver
        storedProcedure.registerStoredProcedureParameter("vFkResidenciaCdResidencia", Integer.class, ParameterMode.IN);
        storedProcedure.setParameter("vFkResidenciaCdResidencia", cdResidencia);
        
        // Execute a procedure
        storedProcedure.execute();
        
        RelatorioConsumo relatorioConsumo = (RelatorioConsumo) storedProcedure.getSingleResult();
        
        return relatorioConsumo;
    }
	
	public RelatorioConsumo callConsultaConsumoMedio60Dias(int cdResidencia) {
        StoredProcedureQuery storedProcedure = entityManager.createStoredProcedureQuery("sp_consultaConsumoMedio60Dias", "consumoMedio");

        // Registre os parâmetros de entrada, se houver
        storedProcedure.registerStoredProcedureParameter("vFkResidenciaCdResidencia", Integer.class, ParameterMode.IN);
        storedProcedure.setParameter("vFkResidenciaCdResidencia", cdResidencia);
        
        // Execute a procedure
        storedProcedure.execute();
        
        RelatorioConsumo relatorioConsumo = (RelatorioConsumo) storedProcedure.getSingleResult();
        
        return relatorioConsumo;
    }
}