package com.lumiere.boot.service;

import java.util.List;

import com.lumiere.boot.domain.Residencia;

public interface ResidenciaService {
	void salvar(Residencia residencia);
	
	List<Residencia> buscarTodos();
	
	List<Residencia> buscarResidenciasPorUsuario(int cdUsuario);
	
	List<Residencia> buscarTodasResidenciasPorUsuario(int cdUsuario);
	
	Residencia buscarResidenciaPorCdResidencia(int cdResidencia);
}
