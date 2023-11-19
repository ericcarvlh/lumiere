package com.lumiere.boot.service;

import java.util.List;

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
	
	public void deletar(int cdDispositivo) {
		dispositivoDao.delete(cdDispositivo);
	}
	
	public void atualizar(Dispositivo dispositivo) {
		dispositivoDao.update(dispositivo);
	}

	public Dispositivo consultarDispositivoPorCdDispositivo(int cdDispositivo) {
		return dispositivoDao.findById(cdDispositivo);
	}
	
	public List<Dispositivo> consultarDispositivosPorCdResidencia(int cdResidencia){
		return dispositivoDao.consultarDispositivosPorCdResidencia(cdResidencia);
	}
}
