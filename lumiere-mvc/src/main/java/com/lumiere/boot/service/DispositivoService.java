package com.lumiere.boot.service;

import java.util.List;

import com.lumiere.boot.domain.Dispositivo;

public interface DispositivoService {
	void salvar(Dispositivo dispositivo);
	
	List<Dispositivo> consultarDispositivosPorCdResidencia(int cdResidencia);
	
	Dispositivo consultarDispositivoPorCdDispositivo(int cdDispositivo);
}
