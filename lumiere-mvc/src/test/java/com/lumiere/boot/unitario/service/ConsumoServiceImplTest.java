package com.lumiere.boot.unitario.service;

import com.lumiere.boot.dao.ConsumoDao;
import com.lumiere.boot.domain.Consumo;
import com.lumiere.boot.service.ConsumoServiceImpl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

class ConsumoServiceImplTest {
    @Mock
    private ConsumoDao consumoDao;

    @InjectMocks
    private ConsumoServiceImpl consumoService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void buscarConsumosPorCdResidencia() {
        List<Consumo> consumosMock = Arrays.asList(
                new Consumo(),
                new Consumo()
        );
        
        when(consumoDao.buscarConsumosPorCdResidencia(anyInt())).thenReturn(consumosMock);

        List<Consumo> consumosResult = consumoService.buscarConsumosPorCdResidencia(1);

        assertEquals(consumosMock, consumosResult);
    }

    @Test
    void buscarConsumosPorCdDispositivo() {
        List<Consumo> consumosMock = Arrays.asList(
                new Consumo(),
                new Consumo()
        );
        
        when(consumoDao.buscarConsumosPorCdDispositivo(anyInt())).thenReturn(consumosMock);

        List<Consumo> consumosResult = consumoService.buscarConsumosPorCdDispositivo(1); 

        assertEquals(consumosMock, consumosResult);
    }
}
