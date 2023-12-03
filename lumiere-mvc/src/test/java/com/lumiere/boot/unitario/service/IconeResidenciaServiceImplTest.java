package com.lumiere.boot.unitario.service;

import com.lumiere.boot.dao.IconeResidenciaDao;
import com.lumiere.boot.domain.IconeResidencia;
import com.lumiere.boot.service.IconeResidenciaServiceImpl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

class IconeResidenciaServiceImplTest {
    @Mock
    private IconeResidenciaDao iconeResidenciaDao;

    @InjectMocks
    private IconeResidenciaServiceImpl iconeResidenciaService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void buscarTodos() {
        List<IconeResidencia> iconesMock = Arrays.asList(
                new IconeResidencia(),
                new IconeResidencia()
        );
        
        when(iconeResidenciaDao.findAll()).thenReturn(iconesMock);

        List<IconeResidencia> iconesResult = iconeResidenciaService.buscarTodos();

        assertEquals(iconesMock, iconesResult);
    }
}
