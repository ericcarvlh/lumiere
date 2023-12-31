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
	public List<Residencia> buscarTodos() {
		return residenciaDao.findAll();
	}

	@Override
	public List<Residencia> buscarResidenciasPorUsuario(int cdUsuario) {
		return residenciaDao.buscarResidenciasPorUsuario(cdUsuario);
	}

	@Override
	public List<Residencia> buscarTodasResidenciasPorUsuario(int cdUsuario) {
		return residenciaDao.buscarTodasResidenciasPorUsuario(cdUsuario);
	}
	
	@Override
	public Residencia buscarResidenciaPorCdResidencia(int cdResidencia) {
		return residenciaDao.findById(cdResidencia);
	}
}
