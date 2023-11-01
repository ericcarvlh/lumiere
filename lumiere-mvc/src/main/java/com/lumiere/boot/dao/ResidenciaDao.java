package com.lumiere.boot.dao;

import java.util.List;

import com.lumiere.boot.domain.Residencia;

public interface ResidenciaDao {
	
	void save(Residencia residencia);
	
	void update(Residencia residencia);
	
	void delete(Long id);
	
	Residencia findById(Long id);
	
	List<Residencia> findAll();
	
}
