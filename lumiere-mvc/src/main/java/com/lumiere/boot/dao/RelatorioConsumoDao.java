package com.lumiere.boot.dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
	
	public List<RelatorioConsumo> callConsultaRelatorioSemanal(int cdResidencia) {
        StoredProcedureQuery storedProcedure = entityManager.createStoredProcedureQuery("sp_consultaRelatorioSemanal", "consultaRelatorioSemanal");

        // Registre os parâmetros de entrada, se houver
        storedProcedure.registerStoredProcedureParameter("vFkResidenciaCdResidencia", Integer.class, ParameterMode.IN);
        storedProcedure.setParameter("vFkResidenciaCdResidencia", cdResidencia);
        
        // Execute a procedure
        storedProcedure.execute();
        
        List<RelatorioConsumo> listaRelatorioSemanal = storedProcedure.getResultList();
        
        return listaRelatorioSemanal;
	}
	
	public List<RelatorioConsumo> callConsultaTotalSemanal(int cdResidencia) {
        StoredProcedureQuery storedProcedure = entityManager.createStoredProcedureQuery("sp_consultaTotalSemanal", "consultaTotalSemanal");

        // Registre os parâmetros de entrada, se houver
        storedProcedure.registerStoredProcedureParameter("vFkResidenciaCdResidencia", Integer.class, ParameterMode.IN);
        storedProcedure.setParameter("vFkResidenciaCdResidencia", cdResidencia);
        
        // Execute a procedure
        storedProcedure.execute();
        
        List<RelatorioConsumo> listaTotalSemanal = storedProcedure.getResultList();
        
        return listaTotalSemanal;
	}
	
	public List<RelatorioConsumo> callConsultaRelatorioAnual(int cdResidencia) {
        StoredProcedureQuery storedProcedure = entityManager.createStoredProcedureQuery("sp_consultaRelatorioAnual", "consultaRelatorioSemanal");

        // Registre os parâmetros de entrada, se houver
        storedProcedure.registerStoredProcedureParameter("vFkResidenciaCdResidencia", Integer.class, ParameterMode.IN);
        storedProcedure.setParameter("vFkResidenciaCdResidencia", cdResidencia);
        
        // Execute a procedure
        storedProcedure.execute();
        
        List<RelatorioConsumo> listaTotalSemanal = storedProcedure.getResultList();
        
        return listaTotalSemanal;
	}
	
	public List<RelatorioConsumo> callConsultaRelatorioMensal(int cdResidencia) {
        StoredProcedureQuery storedProcedure = entityManager.createStoredProcedureQuery("sp_consultaRelatorioMensal", "consultaRelatorioSemanal");

        // Registre os parâmetros de entrada, se houver
        storedProcedure.registerStoredProcedureParameter("vFkResidenciaCdResidencia", Integer.class, ParameterMode.IN);
        storedProcedure.setParameter("vFkResidenciaCdResidencia", cdResidencia);
        
        // Execute a procedure
        storedProcedure.execute();
        
        List<RelatorioConsumo> listaTotalSemanal = storedProcedure.getResultList();
        
        return listaTotalSemanal;
	}
	
	public RelatorioConsumo callConsultaRelatorioPorPeriodo(int cdUsuario, String dataInicial, String dataFinal) {
        StoredProcedureQuery storedProcedure = entityManager.createStoredProcedureQuery("sp_consultaRelatorioPorPeriodo", "relatorioPorPeriodo");

        // Registre os parâmetros de entrada, se houver
        storedProcedure.registerStoredProcedureParameter("vCdUsuario", Integer.class, ParameterMode.IN);
        storedProcedure.setParameter("vCdUsuario", cdUsuario);
		
        Date date;
		try {
	        storedProcedure.registerStoredProcedureParameter("vDataInicial", Date.class, ParameterMode.IN);
			date = new SimpleDateFormat("yyyy-MM-dd").parse(dataInicial);
	        storedProcedure.setParameter("vDataInicial", date);

	        storedProcedure.registerStoredProcedureParameter("vDataFinal", Date.class, ParameterMode.IN);
			date = new SimpleDateFormat("yyyy-MM-dd").parse(dataFinal);
	        storedProcedure.setParameter("vDataFinal", date);
		} catch (ParseException e) {
			e.printStackTrace();
		}

        // Execute a procedure
        storedProcedure.execute();
        
        RelatorioConsumo relatorioConsumo = (RelatorioConsumo) storedProcedure.getSingleResult();
        
		return relatorioConsumo;
	}
}