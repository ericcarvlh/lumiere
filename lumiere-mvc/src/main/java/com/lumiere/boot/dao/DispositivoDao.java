package com.lumiere.boot.dao;

import java.util.List;

import com.lumiere.boot.domain.Dispositivo;


public interface DispositivoDao {

void save(Dispositivo dispositivo);
	
	void update(Dispositivo dispositivo);
	
	void delete(Long id);
	
	Dispositivo findById(Long id);
	
	List<Dispositivo> findAll();
}
