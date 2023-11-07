package com.lumiere.boot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lumiere.boot.dao.ResidenciaDao;
import com.lumiere.boot.domain.Residencia;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class ResidenciaServiceImpl implements ResidenciaService {
	@Autowired
	private ResidenciaDao residenciaDao;
	
	@Override
	public void salvar(Residencia residencia) {
		residenciaDao.save(residencia);
	}

	@Override
	public List<Residencia> buscarResidenciaPorUsuario(int cdUsuario) {
		return residenciaDao.buscarResidenciaPorUsuario(cdUsuario);
	}
	
	@Override
	public List<Residencia> buscarTodos() {
		
		return residenciaDao.findAll();
	}
}
