package com.lumiere.boot.unitario.service;

import com.lumiere.boot.dao.DispositivoDao;
import com.lumiere.boot.domain.Dispositivo;
import com.lumiere.boot.service.DispositivoServiceImpl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

class DispositivoServiceImplTest {
    @Mock
    private DispositivoDao dispositivoDao;

    @InjectMocks
    private DispositivoServiceImpl dispositivoService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void salvar() {
        Dispositivo dispositivoMock = new Dispositivo();

        dispositivoService.salvar(dispositivoMock);

        verify(dispositivoDao, times(1)).save(dispositivoMock);
    }

    @Test
    void deletar() {
        dispositivoService.deletar(1);

        verify(dispositivoDao, times(1)).delete(anyInt());
    }

    @Test
    void atualizar() {
        Dispositivo dispositivoMock = new Dispositivo();

        dispositivoService.atualizar(dispositivoMock);

        verify(dispositivoDao, times(1)).update(dispositivoMock);
    }

    @Test
    void consultarDispositivoPorCdDispositivo() {
        Dispositivo dispositivoMock = new Dispositivo();
        when(dispositivoDao.findById(anyInt())).thenReturn(dispositivoMock);

        Dispositivo dispositivoResult = dispositivoService.consultarDispositivoPorCdDispositivo(1);

        assertEquals(dispositivoMock, dispositivoResult);
    }

    @Test
    void consultarDispositivosPorCdResidencia() {
        List<Dispositivo> dispositivosMock = Arrays.asList(
                new Dispositivo(),
                new Dispositivo()
        );
        
        when(dispositivoDao.consultarDispositivosPorCdResidencia(anyInt())).thenReturn(dispositivosMock);

        List<Dispositivo> dispositivosResult = dispositivoService.consultarDispositivosPorCdResidencia(1);

        assertEquals(dispositivosMock, dispositivosResult);
    }
}
