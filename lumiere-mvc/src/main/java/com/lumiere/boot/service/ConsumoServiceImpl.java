package com.lumiere.boot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lumiere.boot.dao.ConsumoDao;
import com.lumiere.boot.domain.Consumo;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class ConsumoServiceImpl implements ConsumoService {
	@Autowired
	ConsumoDao consumoDao;

	@Override
	public List<Consumo> buscarConsumosPorCdResidencia(int cdResidencia) {
		return consumoDao.buscarConsumosPorCdResidencia(cdResidencia);
	}
	
	public List<Consumo> buscarConsumosPorCdDispositivo(int cdDispositivo) {
		return consumoDao.buscarConsumosPorCdDispositivo(cdDispositivo);
	}
}
