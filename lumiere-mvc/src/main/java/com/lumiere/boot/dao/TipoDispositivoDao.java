package com.lumiere.boot.dao;

import java.util.List;

import com.lumiere.boot.domain.TipoDispositivo;


public interface TipoDispositivoDao {

void save(TipoDispositivo tipodispositivo);
	
	void update(TipoDispositivo tipodispositivo);
	
	void delete(Long id);
	
	TipoDispositivo findById(Long id);
	
	List<TipoDispositivo> findAll();
}
