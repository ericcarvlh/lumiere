package com.lumiere.boot.service;

import java.util.List;

import com.lumiere.boot.domain.Consumo;

public interface ConsumoService {
	List<Consumo> buscarConsumosPorCdResidencia(int cdResidencia);
	
	List<Consumo> buscarConsumosPorCdDispositivo(int cdDispositivo);
}
