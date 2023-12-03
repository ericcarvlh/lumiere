package com.lumiere.boot.unitario.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
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
        List<RelatorioConsumo> relatorioConsumoList = Arrays.asList(
                new RelatorioConsumo(),
                new RelatorioConsumo()
        );

        when(entityManager.createStoredProcedureQuery(any(), eq("MediaConsumoAnual"))).thenReturn(storedProcedureQuery);
        
        when(storedProcedureQuery.getResultList()).thenReturn(relatorioConsumoList);

        List<RelatorioConsumo> result = relatorioConsumoDao.callConsultaMediaConsumoAnual(1);

        verify(storedProcedureQuery, times(1)).execute();

        assertEquals(relatorioConsumoList, result);
    }
    
    @Test
    void callConsultaConsumoTotalPorDispositivo() {
        List<RelatorioConsumo> relatorioConsumoList = Arrays.asList(
                new RelatorioConsumo(),
                new RelatorioConsumo()
        );

        when(entityManager.createStoredProcedureQuery(any(), eq("consumoTotalPorDispositivo"))).thenReturn(storedProcedureQuery);
        
        when(storedProcedureQuery.getResultList()).thenReturn(relatorioConsumoList);

        List<RelatorioConsumo> result = relatorioConsumoDao.callConsultaConsumoTotalPorDispositivo(1);

        verify(storedProcedureQuery, times(1)).execute();

        assertEquals(relatorioConsumoList, result);
    }
    
    @Test
    void callConsultaFaturaAtualTest() {
        RelatorioConsumo expectedResults = new RelatorioConsumo();

        when(entityManager.createStoredProcedureQuery(any(), eq("faturaAtual"))).thenReturn(storedProcedureQuery);
        
        when(storedProcedureQuery.getSingleResult()).thenReturn(expectedResults);

        RelatorioConsumo actualResults = relatorioConsumoDao.callConsultaFaturaAtual(1);

        assertEquals(expectedResults, actualResults);

        verify(storedProcedureQuery, times(1)).execute();
    }
    
    @Test
    void callConsultaConsumoMedio60DiasTest() {
        RelatorioConsumo expectedResults = new RelatorioConsumo();

        when(entityManager.createStoredProcedureQuery(any(), eq("consumoMedio"))).thenReturn(storedProcedureQuery);
        
        when(storedProcedureQuery.getSingleResult()).thenReturn(expectedResults);

        RelatorioConsumo actualResults = relatorioConsumoDao.callConsultaConsumoMedio60Dias(1);

        assertEquals(expectedResults, actualResults);

        verify(storedProcedureQuery, times(1)).execute();
    }
}