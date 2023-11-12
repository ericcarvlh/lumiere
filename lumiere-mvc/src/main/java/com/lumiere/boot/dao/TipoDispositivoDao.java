package com.lumiere.boot.dao;

import java.util.List;

import com.lumiere.boot.domain.TipoDispositivo;


public interface TipoDispositivoDao {

	void save(TipoDispositivo tipodispositivo);
	
	void update(TipoDispositivo tipodispositivo);
	
	void delete(Integer id);
	
	TipoDispositivo findById(Integer id);
	
	List<TipoDispositivo> findAll();
}
