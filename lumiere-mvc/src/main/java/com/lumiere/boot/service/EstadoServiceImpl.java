package com.lumiere.boot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lumiere.boot.dao.EstadoDao;
import com.lumiere.boot.domain.Estado;

@Service 
@Transactional(readOnly = false)
public class EstadoServiceImpl implements EstadoService {
	@Autowired
	private EstadoDao estadoDao;
	
	@Override @Transactional(readOnly = true)
	public List<Estado> buscarUFeIdEstado() {
		return estadoDao.buscarUFeIdEstado();
	}
	
	@Override
	public Estado buscarEstadoPorUF(String UFEstado) {
		return estadoDao.buscarEstadoPorUF(UFEstado);
	}
}
