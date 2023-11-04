package com.lumiere.boot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lumiere.boot.dao.IconeResidenciaDao;
import com.lumiere.boot.domain.IconeResidencia;

@Service 
@Transactional(readOnly = false)
public class IconeResidenciaServiceImpl implements IconeResidenciaService {
	@Autowired
	private IconeResidenciaDao iconeResidenciaDao;
	
	@Override @Transactional(readOnly = true)
	public List<IconeResidencia> buscarTodos() {
		return iconeResidenciaDao.findAll();
	}
}
