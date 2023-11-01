package com.lumiere.boot.dao;

import java.util.List;

import com.lumiere.boot.domain.Consumo;



public interface ConsumoDao {

void save(Consumo consumo);
	
	void update(Consumo consumo);
	
	void delete(Long id);
	
	Consumo findById(Long id);
	
	List<Consumo> findAll();
}
