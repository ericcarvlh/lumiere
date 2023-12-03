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
import com.lumiere.boot.domain.RankingConsumidor;

import jakarta.persistence.EntityManager;
import jakarta.persistence.StoredProcedureQuery;

class RankingConsumidorDaoTest {
    @Mock
    private EntityManager entityManager;

    @Mock
    private StoredProcedureQuery storedProcedureQuery;

    @InjectMocks
    private RankingConsumidorDao rankingConsumidorDao;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void callConsultaRankingConsumidor() {
        List<RankingConsumidor> rankingConsumidorList = Arrays.asList(
                new RankingConsumidor(),
                new RankingConsumidor()
        );

        when(entityManager.createStoredProcedureQuery(any(), eq("rankingConsumidor")))
                .thenReturn(storedProcedureQuery);
        when(storedProcedureQuery.getResultList()).thenReturn(rankingConsumidorList);

        List<RankingConsumidor> result = rankingConsumidorDao.callConsultaRankingConsumidor();

        verify(storedProcedureQuery, times(1)).execute();

        assertEquals(rankingConsumidorList, result);
    }
 }
