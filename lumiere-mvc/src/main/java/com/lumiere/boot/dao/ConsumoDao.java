package com.lumiere.boot.dao;

import java.util.List;

import com.lumiere.boot.domain.Consumo;



public interface ConsumoDao {

	void save(Consumo consumo);
	
	void update(Consumo consumo);
	
	void delete(Integer id);
	
	Consumo findById(Integer id);
	
	List<Consumo> findAll();
	
	List<Consumo> buscarConsumosPorCdResidencia(int cdResidencia);
	
	List<Consumo> buscarConsumosPorCdDispositivo(int cdDispositivo);
}
