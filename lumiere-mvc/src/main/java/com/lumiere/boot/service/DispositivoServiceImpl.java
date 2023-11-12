package com.lumiere.boot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lumiere.boot.dao.DispositivoDao;
import com.lumiere.boot.domain.Dispositivo;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class DispositivoServiceImpl implements DispositivoService {
	@Autowired
	DispositivoDao dispositivoDao;
	
	@Override
	public void salvar(Dispositivo dispositivo) {
		dispositivoDao.save(dispositivo);	
	}

}
