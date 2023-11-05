package com.lumiere.boot.dao;

import java.util.List;

import com.lumiere.boot.domain.Estado;
import com.lumiere.boot.domain.IconeResidencia;


public interface EstadoDao {

	void save(Estado estado);
	
	void update(Estado estado);
	
	void delete(Integer id);
	
	Estado findById(Integer id);
	
	List<Estado> findAll();
	
	List<Estado> buscarUFeIdEstado();
	
	Estado buscarEstadoPorUF(String UFEstado);
}
