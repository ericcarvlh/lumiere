package com.lumiere.boot.service;

import java.util.List;

import com.lumiere.boot.domain.Consumo;

public interface ConsumoService {
	void salvar(Consumo consumo);
	
	List<Consumo> buscarConsumosPorCdResidencia(int cdResidencia);
	
	List<Consumo> buscarConsumosPorCdDispositivo(int cdDispositivo);
}
