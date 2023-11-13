package com.lumiere.boot.dao;

import java.util.List;

import com.lumiere.boot.domain.Residencia;

public interface ResidenciaDao {
	void save(Residencia residencia);
	
	void update(Residencia residencia);
	
	void delete(Integer id);
	
	Residencia findById(Integer id);
	
	List<Residencia> findAll();
	
	List<Residencia> buscarResidenciasPorUsuario(int cdUsuario);
	
	List<Residencia> buscarTodasResidenciasPorUsuario(int cdUsuario);
	
	List<Residencia> buscarResidenciasPorCdResidencia(int cdResidencia);
}
