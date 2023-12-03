package com.lumiere.boot.unitario.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.lumiere.boot.dao.RankingConsumidorDao;
import com.lumiere.boot.dao.RelatorioConsumoDao;
import com.lumiere.boot.domain.RelatorioConsumo;

import jakarta.persistence.EntityManager;
import jakarta.persistence.ParameterMode;
import jakarta.persistence.StoredProcedureQuery;

class RelatorioConsumoDaoTest {
    @Mock
    private EntityManager entityManager;
    
    @Mock
    private RankingConsumidorDao rankingConsumidorDao;

    @Mock
    private StoredProcedureQuery storedProcedureQuery;

    @InjectMocks
    private RelatorioConsumoDao relatorioConsumoDao;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void callConsultaMediaConsumoAnual() {
        List<RelatorioConsumo> listRelatorioConsumo = new ArrayList<RelatorioConsumo>();

        when(entityManager.createStoredProcedureQuery(any(), eq("MediaConsumoAnual"))).thenReturn(storedProcedureQuery);
        
        when(storedProcedureQuery.getResultList()).thenReturn(listRelatorioConsumo);

        List<RelatorioConsumo> listRelatorioConsumoResult = relatorioConsumoDao.callConsultaMediaConsumoAnual(1);

        verify(storedProcedureQuery, times(1)).execute();

        assertEquals(listRelatorioConsumo, listRelatorioConsumoResult);
    }
    
    @Test
    void callConsultaConsumoTotalPorDispositivo() {
        List<RelatorioConsumo> listRelatorioConsumo = new ArrayList<RelatorioConsumo>();

        when(entityManager.createStoredProcedureQuery(any(), eq("consumoTotalPorDispositivo"))).thenReturn(storedProcedureQuery);
        
        when(storedProcedureQuery.getResultList()).thenReturn(listRelatorioConsumo);

        List<RelatorioConsumo> listRelatorioConsumoResult = relatorioConsumoDao.callConsultaConsumoTotalPorDispositivo(1);

        verify(storedProcedureQuery, times(1)).execute();

        assertEquals(listRelatorioConsumo, listRelatorioConsumoResult);
    }
    
    @Test
    void callConsultaFaturaAtualTest() {
        RelatorioConsumo relatorioConsumo = new RelatorioConsumo();

        when(entityManager.createStoredProcedureQuery(any(), eq("faturaAtual"))).thenReturn(storedProcedureQuery);
        
        when(storedProcedureQuery.getSingleResult()).thenReturn(relatorioConsumo);

        RelatorioConsumo relatorioConsumoResult = relatorioConsumoDao.callConsultaFaturaAtual(1);

        assertEquals(relatorioConsumo, relatorioConsumoResult);

        verify(storedProcedureQuery, times(1)).execute();
    }
    
    @Test
    void callConsultaConsumoMedio60DiasTest() {
        RelatorioConsumo relatorioConsumo = new RelatorioConsumo();

        when(entityManager.createStoredProcedureQuery(any(), eq("consumoMedio"))).thenReturn(storedProcedureQuery);
        
        when(storedProcedureQuery.getSingleResult()).thenReturn(relatorioConsumo);

        RelatorioConsumo relatorioConsumoResult = relatorioConsumoDao.callConsultaConsumoMedio60Dias(1);

        assertEquals(relatorioConsumo, relatorioConsumoResult);

        verify(storedProcedureQuery, times(1)).execute();
    }
    
    @Test
    void callConsultaTotalSemanalTest() {
        List<RelatorioConsumo> relatorioConsumoList = new ArrayList<RelatorioConsumo>();
        
        when(entityManager.createStoredProcedureQuery(any(), eq("consultaTotalSemanal"))).thenReturn(storedProcedureQuery);
        
        when(storedProcedureQuery.getSingleResult()).thenReturn(relatorioConsumoList);

        List<RelatorioConsumo> listRelatorioConsumoResult = relatorioConsumoDao.callConsultaTotalSemanal(1);
        
        assertEquals(relatorioConsumoList, listRelatorioConsumoResult);

        verify(storedProcedureQuery, times(1)).execute();
	}
    
    @Test
    void callConsultaRelatorioPorPeriodoTest() throws ParseException {
        RelatorioConsumo relatorioConsumo = new RelatorioConsumo();

        when(entityManager.createStoredProcedureQuery(any(), eq("relatorioPorPeriodo"))).thenReturn(storedProcedureQuery);
        
        when(storedProcedureQuery.getSingleResult()).thenReturn(relatorioConsumo);

        int cdUsuario = 1;
        String dataInicial = "2023-01-01";
        String dataFinal = "2023-12-31";

        Date dateInicial = new SimpleDateFormat("yyyy-MM-dd").parse(dataInicial);
        Date dateFinal = new SimpleDateFormat("yyyy-MM-dd").parse(dataFinal);

        RelatorioConsumo relatorioConsumoResult = relatorioConsumoDao.callConsultaRelatorioPorPeriodo(cdUsuario, dataInicial, dataFinal);

        assertEquals(relatorioConsumo, relatorioConsumoResult);

        verify(storedProcedureQuery).registerStoredProcedureParameter("vCdUsuario", Integer.class, ParameterMode.IN);
        verify(storedProcedureQuery).setParameter("vCdUsuario", cdUsuario);

        verify(storedProcedureQuery).registerStoredProcedureParameter("vDataInicial", Date.class, ParameterMode.IN);
        verify(storedProcedureQuery).setParameter("vDataInicial", dateInicial);

        verify(storedProcedureQuery).registerStoredProcedureParameter("vDataFinal", Date.class, ParameterMode.IN);
        verify(storedProcedureQuery).setParameter("vDataFinal", dateFinal);

        verify(storedProcedureQuery, times(1)).execute();
    }
}