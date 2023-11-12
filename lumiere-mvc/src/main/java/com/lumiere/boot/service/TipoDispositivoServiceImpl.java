package com.lumiere.boot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lumiere.boot.dao.TipoDispositivoDao;
import com.lumiere.boot.domain.TipoDispositivo;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class TipoDispositivoServiceImpl {
	@Autowired
	private TipoDispositivoDao tipoDispositivoDao;
	
	public List<TipoDispositivo> buscarTodos() {
		return tipoDispositivoDao.findAll();
	}

}
