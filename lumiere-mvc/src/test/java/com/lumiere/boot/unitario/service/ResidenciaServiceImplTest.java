package com.lumiere.boot.unitario.service;

import com.lumiere.boot.dao.ResidenciaDao;
import com.lumiere.boot.domain.Residencia;
import com.lumiere.boot.service.ResidenciaServiceImpl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class ResidenciaServiceImplTest {
    @Mock
    private ResidenciaDao residenciaDao;

    @InjectMocks
    private ResidenciaServiceImpl residenciaService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void salvar() {
        Residencia residenciaMock = new Residencia();

        residenciaService.salvar(residenciaMock);

        verify(residenciaDao).save(residenciaMock);
    }

    @Test
    void buscarTodos() {
        List<Residencia> residenciasMock = Arrays.asList(
                new Residencia(),
                new Residencia()
        );
        
        when(residenciaDao.findAll()).thenReturn(residenciasMock);

        List<Residencia> residenciasResult = residenciaService.buscarTodos();

        assertEquals(residenciasMock, residenciasResult);
    }
}