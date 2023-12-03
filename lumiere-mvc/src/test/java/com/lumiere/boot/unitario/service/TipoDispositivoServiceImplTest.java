package com.lumiere.boot.unitario.service;

import com.lumiere.boot.dao.TipoDispositivoDao;
import com.lumiere.boot.domain.TipoDispositivo;
import com.lumiere.boot.service.TipoDispositivoServiceImpl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

class TipoDispositivoServiceImplTest {
    @Mock
    private TipoDispositivoDao tipoDispositivoDao;

    @InjectMocks
    private TipoDispositivoServiceImpl tipoDispositivoService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void buscarTodos() {
        List<TipoDispositivo> tiposDispositivoMock = Arrays.asList(
                new TipoDispositivo(),
                new TipoDispositivo()
        );
        
        when(tipoDispositivoDao.findAll()).thenReturn(tiposDispositivoMock);

        List<TipoDispositivo> tiposDispositivoResult = tipoDispositivoService.buscarTodos();

        assertEquals(tiposDispositivoMock, tiposDispositivoResult);
    }
}