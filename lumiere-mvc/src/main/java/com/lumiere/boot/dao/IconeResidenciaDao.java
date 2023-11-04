package com.lumiere.boot.dao;

import java.util.List;

import com.lumiere.boot.domain.IconeResidencia;

public interface IconeResidenciaDao {
	void save(IconeResidencia iconeResidencia);
	
	void update(IconeResidencia iconeResidencia);
	
	void delete(Integer id);
				
	List<IconeResidencia> findAll();
}
