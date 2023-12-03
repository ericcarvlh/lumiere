package com.lumiere.boot.unitario.service;

import com.lumiere.boot.dao.EstadoDao;
import com.lumiere.boot.domain.Estado;
import com.lumiere.boot.service.EstadoServiceImpl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

class EstadoServiceImplTest {
    @Mock
    private EstadoDao estadoDao;

    @InjectMocks
    private EstadoServiceImpl estadoService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void buscarUFeIdEstado() {
        List<Estado> estadosMock = Arrays.asList(
                new Estado(),
                new Estado()
        );
        
        when(estadoDao.buscarUFeIdEstado()).thenReturn(estadosMock);

        List<Estado> estadosResult = estadoService.buscarUFeIdEstado();

        assertEquals(estadosMock, estadosResult);
    }

    @Test
    void buscarEstadoPorUF() {
        Estado estadoMock = new Estado();
        
        when(estadoDao.buscarEstadoPorUF(anyString())).thenReturn(estadoMock);

        Estado estadoResult = estadoService.buscarEstadoPorUF("SP");

        assertEquals(estadoMock, estadoResult);
    }
}
